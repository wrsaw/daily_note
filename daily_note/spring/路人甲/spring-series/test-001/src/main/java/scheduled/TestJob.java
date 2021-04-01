package scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author WangRui
 * create at 2021/03/31 下午 4:58
 **/
@Component
public class TestJob {

    @Scheduled(fixedRate = 1000)
    public void job(){
        System.out.println("job");
    }
}
