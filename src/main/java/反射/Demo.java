package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射
 */
public class Demo {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("com.example.mytestdemo.Model.Student");

            Constructor constructor = aClass.getConstructor();

            Object student = constructor.newInstance();

            System.out.println(student.toString());

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}