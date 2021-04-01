package async;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author WangRui
 * create at 2021/03/31 下午 3:23
 **/
public class AsyncTest {

    @Test
    public void test() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AsyncConfig.class);
        context.refresh();
        LogService logService = context.getBean(LogService.class);
        System.out.println("start");
        logService.log();
        System.out.println("end");
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AsyncConfig.class);
        context.refresh();
        GoodsService goodsService = context.getBean(GoodsService.class);
        long goodsId = 1L;
        System.out.println("begin");
        long startTime = System.currentTimeMillis();
        Future<String> message = goodsService.getGoodsMessage(goodsId);
        Future<String> desc = goodsService.getGoodsDescribe(goodsId);
        Future<List<String>> comments = goodsService.getGoodsComments(goodsId);

        System.out.println(message.get());
        System.out.println(desc.get());
        System.out.println(comments.get());
        System.out.println(String.format("end, spendTime=%s", System.currentTimeMillis() - startTime));
    }
}
