package s6;

/**
 * @author WangRui
 * create at 2021/04/07 下午 2:25
 **/
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("start");
                /*try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    this.interrupt();
                    e.printStackTrace();
                }*/
                while (true) {
                    if (isInterrupted()) {
                        System.out.println("interrupt");
                        break;
                    }
                }
            }
        };
        thread.setName("t1");
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
