public class LazyLoading {

    public static void main(String[] args) throws ClassNotFoundException {
        //P p;
        //X x = new X();
        //System.out.println(P.i);
        //System.out.println(P.j);
        //Class.forName("LazyLoading$P");
    }

    public static class P {
        static final int i = 1;
        static int j = 2;
        //类被加载时一定会执行静态代码块
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }

}
