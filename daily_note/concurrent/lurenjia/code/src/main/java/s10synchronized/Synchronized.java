package s10synchronized;

/**
 * @author WangRui
 * create at 2021/04/15 下午 5:25
 **/
public class Synchronized {
    private int num = 0;

    //修饰实例方法
    private synchronized void add() {
        num++;
    }

    public static class MyThread extends Thread {
        private Synchronized s;
        MyThread(Synchronized s) {
            this.s = s;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                this.s.add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Synchronized s = new Synchronized();
        MyThread t1 = new MyThread(s);
        MyThread t2 = new MyThread(s);
        MyThread t3 = new MyThread(s);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(s.num);
    }
}
