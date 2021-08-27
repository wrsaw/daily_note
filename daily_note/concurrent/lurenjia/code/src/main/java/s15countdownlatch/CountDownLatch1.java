package s15countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author WangRui
 * create at 2021/08/27 下午 3:41
 **/
public class CountDownLatch1 {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static class T extends Thread {
        private String name;

        T(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " start:" + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
                System.out.println(name + " finish:" + System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start:" + System.currentTimeMillis());
        T t1 = new T("T1");
        t1.start();
        T t2 = new T("T2");
        t2.start();

        countDownLatch.await();
        System.out.println("main finish:" + System.currentTimeMillis());
    }
}
