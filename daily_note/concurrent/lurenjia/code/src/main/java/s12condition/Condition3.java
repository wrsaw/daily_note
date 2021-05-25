package s12condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/25 下午 3:44
 **/
public class Condition3 {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    private static class T extends Thread {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                System.out.println(this.isInterrupted());
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(3000);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
