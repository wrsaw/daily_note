package s8threadgroup;

/**
 * @author WangRui
 * create at 2021/04/08 下午 4:16
 **/
public class ParentThreadGroup {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup().getParent());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent());
    }
}
