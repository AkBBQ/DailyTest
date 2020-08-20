package com.example.mytestdemo.HighJavaDemo.Reflect;

import com.example.mytestdemo.Model.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Reflet
 */
public class Demo {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("com.example.mytestdemo.Model.Student");

            Constructor constructor = aClass.getConstructor();

            Object studentObject = constructor.newInstance();

            Student student = (Student) studentObject;
            student.setId(1);
            student.setName("hzr");
            student.setAge(23);
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