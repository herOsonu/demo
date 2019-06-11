package Factory;

import java.util.ResourceBundle;

public class BeanFactory {
    private static ResourceBundle bundle;
    static {
        //为什么写在静态块里，不直接实例化静态变量
        bundle=ResourceBundle.getBundle("instance");
    }
    public static<T>T getInstance(String key,Class<T> clazz){
        String className=bundle.getString(key);
        try {
            return (T)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
