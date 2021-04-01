package scheduled;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author WangRui
 * create at 2021/03/31 下午 5:10
 **/
public class ScheduledTest {

    @Test
    public void test() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ScheduledConfig.class);
        context.refresh();
        Thread.sleep(10000);
    }

}
