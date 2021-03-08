public class WayToRun {
    //Run-Edit Configurations-VM options 指定执行模式
    //对比默认模式和编译模式可把i范围扩大10倍
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            f();
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            f();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void f() {
        for (long i = 0; i < 10000; i++) {
            long j = i % 3;
        }
    }
}
