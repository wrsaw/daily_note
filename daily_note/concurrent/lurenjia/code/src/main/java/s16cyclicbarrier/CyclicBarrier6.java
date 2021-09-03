package s16cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author WangRui
 * create at 2021/09/02 下午 3:53
 **/
public class CyclicBarrier6 {
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
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
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
            if (i == 2) {
                t.interrupt();
            }
        }
        System.out.println("第一轮结束:" + System.currentTimeMillis());
        cyclicBarrier.reset();
        for (int i = 0; i < 5; i++) {
            T t = new T("thread" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
        }
        System.out.println("第二轮结束:" + System.currentTimeMillis());
    }
}
