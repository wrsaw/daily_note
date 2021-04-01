package event;

import org.springframework.context.ApplicationEvent;

/**
 * @author WangRui
 * create at 2021/03/26 下午 2:48
 **/
public class RegisterEvent extends ApplicationEvent {

    private String userName;

    public RegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
