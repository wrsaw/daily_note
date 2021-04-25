package s6;

/**
 * @author WangRui
 * create at 2021/04/07 下午 2:31
 **/
public class ThreadInterrupt2 {
    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("start");
            while (true) {
                /*try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if (flag) {
                    System.out.println("out");
                    break;
                }
            }
        });
        thread.setName("t1");
        thread.start();
        Thread.sleep(1000);
        flag = true;
    }
}
