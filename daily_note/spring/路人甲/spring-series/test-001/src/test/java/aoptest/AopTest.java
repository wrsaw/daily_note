package aoptest;

import aop.FundsService;
import aop.SendMsgThrowsAdvice;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author WangRui
 * create at 2021/03/30 下午 3:52
 **/
public class AopTest {
    @Test
    public void test() {
        ProxyFactory proxyFactory = new ProxyFactory(new FundsService());
        proxyFactory.addAdvice((MethodBeforeAdvice) (method, objects, o) -> {
            String userName = (String) objects[0];
            if (!"有钱人".equals(userName)) {
               throw new RuntimeException(String.format("%s非法访问", userName));
            }
        });
        FundsService proxy = (FundsService) proxyFactory.getProxy();
        proxy.recharge("有钱人", 100);
        proxy.recharge("张三", 100);
    }

    @Test
    public void test2() {
        ProxyFactory proxyFactory = new ProxyFactory(new FundsService());
        proxyFactory.addAdvice(new SendMsgThrowsAdvice());
        FundsService proxy = (FundsService) proxyFactory.getProxy();
        proxy.cashOut("有钱人", 10000);
    }
}
