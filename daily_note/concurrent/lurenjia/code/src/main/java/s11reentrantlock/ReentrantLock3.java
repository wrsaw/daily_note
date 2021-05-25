package s11reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/18 下午 4:14
 **/
public class ReentrantLock3 {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    private static class MyThread extends Thread {
        int lock;

        MyThread(String name, int lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                if (lock == 0) {
                    lock1.lockInterruptibly();
                    Thread.sleep(1000);
                    lock2.lockInterruptibly();
                } else {
                    lock2.lockInterruptibly();
                    Thread.sleep(1000);
                    lock1.lockInterruptibly();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("t1", 1);
        MyThread t2 = new MyThread("t2", 0);
        t1.start();
        t2.start();

        Thread.sleep(3000);
        t1.interrupt();
    }
}
