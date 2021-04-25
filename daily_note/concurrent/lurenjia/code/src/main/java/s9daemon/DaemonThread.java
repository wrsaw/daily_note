package s9daemon;

/**
 * @author WangRui
 * create at 2021/04/09 上午 10:53
 **/
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(this.isDaemon() ? "守护线程" : "用户线程");
                while (true) {

                }
            }
        };
        thread.setName("t1");
        thread.start();
        thread.setDaemon(true);
        Thread.sleep(1000);
        System.out.println("主线程结束");
    }
}
