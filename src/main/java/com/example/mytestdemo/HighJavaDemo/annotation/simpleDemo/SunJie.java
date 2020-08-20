package com.example.mytestdemo.HighJavaDemo.annotation.simpleDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

// 保留到运行时，可通过注解获取
@Retention(RetentionPolicy.RUNTIME)
//注解用于字段上
@Target(ElementType.FIELD)
public @interface SunJie {
    String name();
    int age();

}
