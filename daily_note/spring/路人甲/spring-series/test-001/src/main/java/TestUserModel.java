import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author WangRui
 * create at 2021/03/19 下午 5:55
 **/
public class TestUserModel {
    public static void main(String[] args) {
        String xml = "classpath:bean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xml);
        UserModel userModel1 = context.getBean("userModel1", UserModel.class);
        System.out.println(userModel1.toString());
        UserModel userModel2 = context.getBean("userModel2", UserModel.class);
        System.out.println(userModel2.toString());
        UserModel userModel3 = context.getBean("userModelBuild1", UserModel.class);
        System.out.println(userModel3.toString());
        UserModel userModel4 = context.getBean("userModelBuild2", UserModel.class);
        System.out.println(userModel4.toString());
    }
}
