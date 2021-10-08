package s18executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author WangRui
 * create at 2021/09/10 上午 10:38
 **/
public class Executor3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> list = new ArrayList<>();
        int taskCount = 5;
        for (int i = 0; i < taskCount; i++) {
            int j = 2 * i;
            list.add(()->{
                TimeUnit.SECONDS.sleep(j);
                return j;
            });
        }
        solve(executorService, list, res -> System.out.println(System.currentTimeMillis() + ":" + res));

        executorService.shutdown();
    }

    private static <T> void solve(Executor e, Collection<Callable<T>> solvers, Consumer<T> use) throws InterruptedException, ExecutionException {
        CompletionService<T> ecs = new ExecutorCompletionService<>(e);
        for (Callable<T> solver : solvers) {
            ecs.submit(solver);
        }
        for (int i = 0; i < solvers.size(); i++) {
            T r = ecs.take().get();
            if (r != null) {
                use.accept(r);
            }
        }
    }
}


