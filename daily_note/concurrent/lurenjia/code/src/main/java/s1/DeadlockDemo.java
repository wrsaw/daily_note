package s1;

/**
 * @author WangRui
 * create at 2021/04/02 下午 12:22
 **/
public class DeadlockDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(new DeadlockRunnable(obj1, obj2, true));
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new DeadlockRunnable(obj1, obj2, false));
        t2.setName("t2");
        t2.start();
    }


    private static class DeadlockRunnable implements Runnable {
        private Object obj1;
        private Object obj2;
        private boolean flag;

        DeadlockRunnable(Object obj1, Object obj2, boolean flag) {
            this.obj1 = obj1;
            this.obj2 = obj2;
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                synchronized (obj1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println("aa");
                    }
                }
            } else {
                synchronized (obj2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        System.out.println("bb");
                    }
                }
            }
        }
    }
}
