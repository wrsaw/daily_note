package s13locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author WangRui
 * create at 2021/05/27 下午 3:48
 **/
public class LockSupport4 {
    private static class BlockerDemo {

    }

    private static class T extends Thread {
        @Override
        public void run() {
            LockSupport.park();
        }
    }

    private static class T2 extends Thread {
        @Override
        public void run() {
            LockSupport.park(new BlockerDemo());
        }
    }

    public static void main(String[] args) {
        T t = new T();
        t.setName("t");
        t.start();
        T2 t2 = new T2();
        t2.setName("t2");
        t2.start();
    }
}
