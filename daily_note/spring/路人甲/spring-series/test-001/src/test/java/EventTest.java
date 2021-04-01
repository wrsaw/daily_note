import event.MyConfig;
import event.RegisterService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author WangRui
 * create at 2021/03/26 下午 2:55
 **/
public class EventTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();
        RegisterService registerService = (RegisterService) context.getBean("registerService");
        registerService.register("张三");
    }
}
