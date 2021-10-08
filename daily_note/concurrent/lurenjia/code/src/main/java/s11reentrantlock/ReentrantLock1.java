package s11reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/04/29 下午 5:20
 **/
public class ReentrantLock1 {
    private static int num = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static void add() {
        reentrantLock.lock();
        reentrantLock.lock();
        try {
            num++;
        } finally {
            reentrantLock.unlock();
            reentrantLock.unlock();
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                ReentrantLock1.add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(ReentrantLock1.num);
    }
}
