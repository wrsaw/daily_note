package s17threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义饱和策略
 * @author WangRui
 * create at 2021/09/08 上午 10:45
 **/
public class ThreadPool3 {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
            (r, executor) -> System.out.println(Thread.currentThread().getName() + "无法执行"));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int j = i;
            executor.execute(() -> {
                System.out.println("执行任务" + j);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
