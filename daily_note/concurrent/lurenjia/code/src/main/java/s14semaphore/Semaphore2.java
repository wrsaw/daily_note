package s14semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author WangRui
 * create at 2021/07/20 下午 5:27
 **/
public class Semaphore2 {
    static Semaphore semaphore = new Semaphore(1);

    public static class T extends Thread {
        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",获取许可,当前可用许可数量:" + semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(100);
                System.out.println(System.currentTimeMillis()+","+thread.getName()+",运行结束!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",当前可用许可数量:" + semaphore.availablePermits());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        T t2 = new T("t2");
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        T t3 = new T("t3");
        t3.start();
        t2.interrupt();
        t3.interrupt();
    }
}
