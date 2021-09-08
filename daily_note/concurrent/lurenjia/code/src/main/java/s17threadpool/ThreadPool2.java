package s17threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程创建工厂
 * @author WangRui
 * create at 2021/09/08 上午 10:45
 **/
public class ThreadPool2 {
    private static AtomicInteger threadNum = new AtomicInteger();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(7), r -> {
        Thread t = new Thread(r);
        t.setName("自定义线程-" + threadNum.getAndIncrement());
        return t;
    }, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + "执行任务"));
        }
        executor.shutdown();
    }
}
