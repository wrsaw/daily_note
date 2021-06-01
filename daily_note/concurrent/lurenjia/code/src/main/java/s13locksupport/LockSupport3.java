package s13locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author WangRui
 * create at 2021/05/27 下午 3:48
 **/
public class LockSupport3 {
    private static class T extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":开始执行");
            System.out.println("park()前中断状态：" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println("park()后中断状态：" + Thread.currentThread().isInterrupted());
            System.out.println(System.currentTimeMillis() + ":被唤醒");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(5000);
        t.interrupt();
        System.out.println(System.currentTimeMillis() + ":主线程执行完毕");
    }
}
