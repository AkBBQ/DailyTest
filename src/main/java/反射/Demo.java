package 反射;

import java.lang.reflect.Constructor;

/**
 * 反射
 */
public class Demo {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("com.example.mytestdemo.Model.Student");

            Constructor constructor = aClass.getConstructor();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}