package async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Executor;

/**
 * @author WangRui
 * create at 2021/03/31 下午 3:22
 **/
@ComponentScan
@EnableAsync
public class AsyncConfig {

    public static final String GOODS_MESSAGE_THREAD = "goods-message-thread";
    public static final String GOODS_DESC_THREAD = "goods-desc-thread";

    /*@Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("myThread-");
        return executor;
    }*/

    @Bean(GOODS_MESSAGE_THREAD)
    public Executor goodsMessageExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("goods-message-thread-");
        return executor;
    }
    @Bean(GOODS_DESC_THREAD)
    public Executor goodsDescExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("goods-desc-thread-");
        return executor;
    }

    @Bean
    public AsyncConfigurer asyncConfigurer(@Qualifier("logExecutor") Executor executor) {
        return new AsyncConfigurer() {
            @Override
            public Executor getAsyncExecutor() {
                return executor;
            }

            @Override
            public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
                return (throwable, method, objects) -> {
                    String msg = String.format("方法[%s],参数[%s],发送异常了，异常详细信息:", method, Arrays.asList(objects));
                    System.out.println(msg);
                    throwable.printStackTrace();
                };
            }
        };
    }

    @Bean
    public Executor logExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("myThread-");
        return executor;
    }
}
