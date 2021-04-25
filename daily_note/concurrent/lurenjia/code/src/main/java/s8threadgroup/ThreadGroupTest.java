package s8threadgroup;

/**
 * @author WangRui
 * create at 2021/04/08 下午 3:31
 **/
public class ThreadGroupTest {
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("threadName:" + Thread.currentThread().getName());
            System.out.println("所属线程组:" + Thread.currentThread().getThreadGroup().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("thread-group-1");
        Thread thread1 = new Thread(threadGroup1, new MyRunnable(), "t1");
        Thread thread2 = new Thread(threadGroup1, new MyRunnable(), "t2");
        thread1.start();
        thread2.start();
        System.out.println("threadCount1:" + threadGroup1.activeCount());
        System.out.println("threadGroupCount1:" + threadGroup1.activeGroupCount());
        System.out.println("threadGroupName1:" + threadGroup1.getName());
        System.out.println("threadGroupParentName1:" + threadGroup1.getParent().getName());
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "thread-group-2");
        System.out.println("threadCount2:" + threadGroup2.activeCount());
        System.out.println("threadGroupCount2:" + threadGroup2.activeGroupCount());
        System.out.println("threadGroupName2:" + threadGroup2.getName());
        System.out.println("threadGroupParentName2:" + threadGroup2.getParent().getName());
        System.out.println("threadCount1:" + threadGroup1.activeCount());
        System.out.println("threadGroupCount1:" + threadGroup1.activeGroupCount());
        threadGroup1.list();
    }
}
