package s12condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/25 下午 3:32
 **/
public class Condition2 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static class T1 extends Thread {
        T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":" + this.getName() + "准备获取锁");
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "获取锁");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis() + ":" + this.getName() + "释放锁");
        }
    }

    private static class T2 extends Thread {
        T2(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":" + this.getName() + "准备获取锁");
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "获取锁");
                condition.signal();
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "signal");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis() + ":" + this.getName() + "释放锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1("T1");
        t1.start();
        Thread.sleep(5000);
        T2 t2 = new T2("T2");
        t2.start();
    }
}
