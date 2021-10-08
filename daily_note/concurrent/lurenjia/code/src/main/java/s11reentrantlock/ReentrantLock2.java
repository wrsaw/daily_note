package s11reentrantlock;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/17 下午 3:45
 **/
public class ReentrantLock2 {
    private static ReentrantLock lock = new ReentrantLock(true);

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    Thread.sleep(500);
                    System.out.println(this.getName());
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
