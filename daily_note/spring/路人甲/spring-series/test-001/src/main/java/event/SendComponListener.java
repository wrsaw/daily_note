package event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author WangRui
 * create at 2021/03/26 下午 2:51
 **/
@Component
public class SendComponListener {
    @EventListener
    @Order(1)
    public void onApplicationEvent(RegisterEvent registerEvent) {
        System.out.println("send compon to " + registerEvent.getUserName());
    }
}
