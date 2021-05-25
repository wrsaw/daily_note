package s12condition;

/**
 * @author WangRui
 * create at 2021/05/25 下午 3:08
 **/
public class Condition1 {
    private static final Object lock = new Object();

    private static class T1 extends Thread {
        T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":" + this.getName() + "准备获取锁");
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "获取锁");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "获取锁");
                lock.notify();
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "notify");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
