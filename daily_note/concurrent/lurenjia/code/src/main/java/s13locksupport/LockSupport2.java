package s13locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author WangRui
 * create at 2021/05/27 下午 3:48
 **/
public class LockSupport2 {
    private static class T extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":开始执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + ":被唤醒");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(1000);
        LockSupport.unpark(t);
        System.out.println(System.currentTimeMillis() + ":主线程执行完毕");
    }
}
