import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author WangRui
 * create at 2021/03/19 下午 5:10
 **/
public class Client {

    public static void main(String[] args) {
        //1.bean配置文件位置
        String beanXml = "classpath:bean.xml";

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        //3.从容器中获取需要的bean
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);

        //4.使用对象
        helloWorld.say();
    }
}
