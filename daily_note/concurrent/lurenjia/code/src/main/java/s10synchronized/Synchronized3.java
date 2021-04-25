package s10synchronized;

/**
 * @author WangRui
 * create at 2021/04/25 上午 11:23
 **/
public class Synchronized3 {
    private static final Synchronized3 ins = new Synchronized3();
    private static int num = 0;

    public static class MyThread extends Thread {

        @Override
        public void run() {
            //修饰代码块
            synchronized (ins) {
                for (int i = 0; i < 1000000; i++) {
                    num++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(Synchronized3.num);
    }
}
