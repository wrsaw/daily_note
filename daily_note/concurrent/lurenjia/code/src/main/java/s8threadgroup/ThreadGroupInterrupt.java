package s8threadgroup;

/**
 * @author WangRui
 * create at 2021/04/08 下午 4:21
 **/
public class ThreadGroupInterrupt {
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("threadName:" + Thread.currentThread().getName());
            System.out.println("所属线程组:" + Thread.currentThread().getThreadGroup().getName());
            while (!Thread.currentThread().isInterrupted()) {
            }
            System.out.println(Thread.currentThread().getName() + "out");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup1 = new ThreadGroup("thread-group-1");
        Thread thread1 = new Thread(threadGroup1, new MyRunnable(), "t1");
        Thread thread2 = new Thread(threadGroup1, new MyRunnable(), "t2");
        thread1.start();
        thread2.start();
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "thread-group-2");
        Thread thread3 = new Thread(threadGroup2, new MyRunnable(), "t3");
        Thread thread4 = new Thread(threadGroup2, new MyRunnable(), "t4");
        thread3.start();
        thread4.start();
        Thread.sleep(1000);
        threadGroup1.list();
        System.out.println("-------------------------");
        threadGroup1.interrupt();
        Thread.sleep(1000);
        threadGroup1.list();
    }
}
