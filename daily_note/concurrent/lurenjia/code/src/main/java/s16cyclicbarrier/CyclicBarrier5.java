package s16cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author WangRui
 * create at 2021/09/02 下午 3:53
 **/
public class CyclicBarrier5 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    private static class T extends Thread {
        private String name;

        T(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            long time = System.currentTimeMillis();
            System.out.println(name + ":" + time + " 开始等待");
            try {
                if ("thread2".equals(name)) {
                    cyclicBarrier.await(500, TimeUnit.MILLISECONDS);
                } else {
                    cyclicBarrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long time2 = System.currentTimeMillis();
            System.out.println(name + ":" + time2 + " 等待" + (time2 - time) + "ms处理完成");
        }
    }

    public static void main(String[] args) {
        System.out.println("开始:" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            T t = new T("thread" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
        }
        System.out.println("结束:" + System.currentTimeMillis());
    }
}
