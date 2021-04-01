package event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author WangRui
 * create at 2021/03/26 下午 2:52
 **/
@Service
public class RegisterService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String userName) {
        System.out.println("register " + userName);
        applicationEventPublisher.publishEvent(new RegisterEvent(this, userName));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
