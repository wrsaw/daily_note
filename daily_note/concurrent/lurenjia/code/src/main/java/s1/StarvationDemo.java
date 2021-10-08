package s1;

import java.util.concurrent.*;

/**
 * @author WangRui
 * create at 2021/04/02 下午 2:18
 **/
public class StarvationDemo {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    private static class AnotherCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("AnotherCallable");
            return "AnotherCallable";
        }
    }

    private static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("MyCallable");
            Future<String> future = executorService.submit(new AnotherCallable());
            return "MyCallable" + future.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(new MyCallable());
        System.out.println("main");
        System.out.println("main" + future.get());
        System.out.println("over");
        executorService.shutdown();
    }
}
