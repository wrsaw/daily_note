
/**
 * @author WangRui
 * create at 2021/03/19 下午 5:48
 **/
public class UserModel {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserModel() {
        this.name = "default";
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static UserModel build1() {
        UserModel userModel = new UserModel();
        userModel.setName("build default");
        return userModel;
    }

    public static UserModel build2(String name, int age) {
        UserModel userModel = new UserModel();
        userModel.setName("build " + name);
        userModel.setAge(age);
        return userModel;
    }

    public UserModel build21() {
        UserModel userModel = new UserModel();
        userModel.setName("build2 default");
        return userModel;
    }

    public UserModel build22(String name, int age) {
        UserModel userModel = new UserModel();
        userModel.setName("build2 " + name);
        userModel.setAge(age);
        return userModel;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
