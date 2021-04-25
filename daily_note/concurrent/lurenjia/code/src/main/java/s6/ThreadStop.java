package s6;

import lombok.extern.slf4j.Slf4j;

/**
 * @author WangRui
 * create at 2021/04/06 下午 5:13
 **/
@Slf4j
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            boolean flag = true;
            log.info("start");
            while (flag) {

            }
            log.info("end");
        });
        thread.setName("t1");
        thread.start();
        Thread.sleep(1000);
        thread.stop();
        log.info(String.valueOf(thread.getState()));
        Thread.sleep(1000);
        log.info(String.valueOf(thread.getState()));
    }
}
