package s12condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/25 下午 4:03
 **/
public class Condition5 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static class T extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                boolean result = condition.await(3, TimeUnit.SECONDS);
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(1000);
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
