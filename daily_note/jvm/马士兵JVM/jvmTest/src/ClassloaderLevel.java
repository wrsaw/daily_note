public class ClassloaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(ClassloaderLevel.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassloaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(ClassloaderLevel.class.getClassLoader().getParent());
        System.out.println(ClassloaderLevel.class.getClassLoader().getParent().getParent());
    }
}
