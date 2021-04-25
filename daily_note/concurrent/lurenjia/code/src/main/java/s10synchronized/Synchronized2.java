package s10synchronized;

/**
 * @author WangRui
 * create at 2021/04/25 上午 11:20
 **/
public class Synchronized2 {
    private static int num = 0;

    //修饰静态方法
    private static synchronized void add() {
        num++;
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                Synchronized2.add();
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
        System.out.println(Synchronized2.num);
    }
}
