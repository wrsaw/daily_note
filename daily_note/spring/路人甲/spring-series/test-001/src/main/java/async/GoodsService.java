package async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author WangRui
 * create at 2021/03/31 下午 3:52
 **/
@Service
public class GoodsService {

    @Async(AsyncConfig.GOODS_MESSAGE_THREAD)
    public Future<String> getGoodsMessage(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println(String.format("%s:getGoodsMessage", Thread.currentThread()));
        return AsyncResult.forValue(String.format("goodsMessage,goodsId:%s", goodsId));
    }

    @Async(AsyncConfig.GOODS_DESC_THREAD)
    public Future<String> getGoodsDescribe(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println(String.format("%s:getGoodsDescribe", Thread.currentThread()));
        return AsyncResult.forValue(String.format("goodsDescribe,goodId:%s", goodsId));
    }

    @Async
    public Future<List<String>> getGoodsComments(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        List<String> list = Arrays.asList("comment1", "comment2");
        System.out.println(String.format("%s:getGoodsComments", Thread.currentThread()));
        return AsyncResult.forValue(list);
    }
}
