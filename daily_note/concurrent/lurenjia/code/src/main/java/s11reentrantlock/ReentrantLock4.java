package s11reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/24 下午 5:48
 **/
public class ReentrantLock4 {
    private static ReentrantLock lock = new ReentrantLock();

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + "开始获取锁");
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)) {
                    System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + "获取锁成功");
                    Thread.sleep(5000);
                } else {
                    System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + "获取锁失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}
