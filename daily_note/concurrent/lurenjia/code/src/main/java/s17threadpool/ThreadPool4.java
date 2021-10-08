package s17threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author WangRui
 * create at 2021/09/08 下午 3:24
 **/
public class ThreadPool4 {
    static class R implements Runnable {
        private String name;

        R(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "处理" + this.name);
        }
    }

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(7), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()) {
        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println(Thread.currentThread().getName() + "开始执行");
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }

        @Override
        protected void terminated() {
            System.out.println(Thread.currentThread().getName() + "关闭");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executor.execute(new R("任务-" + i));
        }
        TimeUnit.SECONDS.sleep(1);
        executor.shutdown();
    }
}
