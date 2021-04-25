package s9daemon;

/**
 * @author WangRui
 * create at 2021/04/09 上午 11:15
 **/
public class DaemonThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " : " + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程")));
        System.out.println(Thread.currentThread().getName() + " : " + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : " + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " : " + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程")));
            t3.setName("t3");
            t3.start();
        });
        t2.setName("t2");
        t2.setDaemon(true);
        t2.start();
        Thread.sleep(1000);
    }
}
