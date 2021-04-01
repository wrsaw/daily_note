package async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author WangRui
 * create at 2021/03/31 下午 3:21
 **/
@Service
public class LogService {

    @Async
    public void log() throws InterruptedException {
        System.out.println(Thread.currentThread() + "log start");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread() + "log end");
        throw new IllegalArgumentException("无返回值的异常!");
    }
}
