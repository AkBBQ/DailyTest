package com.example.mytestdemo.HighJavaDemo.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 反射相关
 */

public class GetReflectDemo {
    public static void main(String[] args) throws Exception {
        // 3钟反射获取class方法
        Class c1 = Class.forName("com.example.mytestdemo.HighJavaDemo.Reflect.Student");
        Class c2 = Student.class;
        Student student = new Student();
        Class c3 = student.getClass();

        System.out.println(c1.getName());

        //获取实例对象
        Object o = c1.newInstance();
        Student s = (Student) o;

        //获取类的全部属性
        Field[] fs = c1.getDeclaredFields();
        for(Field filed:fs){
            System.out.println(filed.getName());
        }

        //获取构造函数
        Constructor constructor = c1.getConstructor(String.class);
        Object ss = constructor.newInstance("SUNJIE");
        Student ss1 = (Student)ss;
        System.out.println(ss1.getName());

    }
}