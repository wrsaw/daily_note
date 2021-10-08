package s17threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池基本流程及使用
 * @author WangRui
 * create at 2021/09/07 下午 4:55
 **/
public class ThreadPool1 {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(7), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int j = i;
            String taskName = "任务" + j;
            executor.execute(() -> {
                //模拟任务内部处理耗时
                try {
                    TimeUnit.SECONDS.sleep(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + taskName + "处理完毕");
            });
        }
        //关闭线程池
        executor.shutdown();
    }
}
