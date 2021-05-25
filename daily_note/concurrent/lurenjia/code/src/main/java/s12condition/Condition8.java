package s12condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangRui
 * create at 2021/05/25 下午 4:11
 **/
public class Condition8<E> {
    private int size;
    private LinkedList<E> list = new LinkedList();

    Condition8(int size) {
        this.size = size;
    }

    private ReentrantLock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    private void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == size) {
                c1.await();
            }
            list.add(e);
            System.out.println("入队" + e);
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    private E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while (list.size() == 0) {
                c1.await();
            }
            e = list.removeFirst();
            System.out.println("出队" + e);
            c1.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Condition8<Integer> condition8 = new Condition8<>(3);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    condition8.enqueue(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    condition8.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
