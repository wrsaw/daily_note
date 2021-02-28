import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String realName = "E://daily_note/daily_note/马士兵JVM/" + name.replace(".", "/") + ".class";
        File file = new File(realName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int b;
            while ((b = fileInputStream.read()) != -1) {
                outputStream.write(b);

            }
            byte[] bytes = outputStream.toByteArray();
            fileInputStream.close();
            outputStream.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class clazz = customClassLoader.findClass("CustomClassLoaderTest");
        Method method = clazz.getDeclaredMethod("f");
        String fResult = (String) method.invoke(clazz.newInstance());
        System.out.println("main:" + fResult);
        System.out.println(customClassLoader.getClass().getClassLoader());
        System.out.println(customClassLoader.getParent());
    }
}
