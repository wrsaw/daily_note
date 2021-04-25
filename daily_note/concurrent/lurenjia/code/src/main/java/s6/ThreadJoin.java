package s6;

/**
 * @author WangRui
 * create at 2021/04/07 下午 5:20
 **/
public class ThreadJoin {
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                num++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("num=" + num);
            }
        });

        thread.start();
        thread.join();
        //thread.join(2000);
        System.out.println("end");
    }
}
