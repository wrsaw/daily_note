package s6;

/**
 * @author WangRui
 * create at 2021/04/07 下午 4:29
 **/
public class ThreadNotify {
    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + " t1 start");
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + " t1 before wait");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + " t1 end");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + " t2 start");
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + " t2 before notify");
                obj.notify();
                System.out.println(System.currentTimeMillis() + " t2 end");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}