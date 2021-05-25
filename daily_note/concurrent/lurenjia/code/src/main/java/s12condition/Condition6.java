package s12condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/25 下午 3:56
 **/
public class Condition6 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static class T extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                long result = condition.awaitNanos(TimeUnit.SECONDS.toNanos(5));
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        t.start();
    }
}
