package com.example.mytestdemo.HighJavaDemo.annotation.simpleDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 自定义注解
 */

@SunJie
public class Test {

    @SunJie(name = "SUN", age = 12)
    String person;


    public static void main(String[] args) {
        //获取类模板
        Class c = Test.class;
        Annotation annotation1 = c.getAnnotation(SunJie.class);

        // 获取所有字段
        for (Field field : c.getDeclaredFields()) {
            // 判断这个字段是否有Sunjie注解
            if (field.isAnnotationPresent(SunJie.class)) {
                SunJie annotation = field.getAnnotation(SunJie.class);
                System.out.println("字段:[" + field.getName() + "], 描述:[" + annotation.name() + "], 长度:[" + annotation.age() + "]");
            }
        }
    }
}