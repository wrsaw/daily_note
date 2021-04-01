package event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author WangRui
 * create at 2021/03/26 下午 2:50
 **/
@Component
public class SendEmailListener  {
//public class SendEmailListener implements ApplicationListener<RegisterEvent> {
    @EventListener
    @Order(0)
    public void onApplicationEvent(RegisterEvent registerEvent) {
        System.out.println(Thread.currentThread() + "send email to " + registerEvent.getUserName());
    }
}
