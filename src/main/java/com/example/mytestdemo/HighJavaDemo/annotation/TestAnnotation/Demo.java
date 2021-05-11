package com.example.mytestdemo.HighJavaDemo.annotation.TestAnnotation;


import org.springframework.lang.Nullable;


public class Demo {

    public static void main(String[] args) {
        hello(null);

    }

    private static String hello(@Nullable String s1){
        System.out.println(s1.toString());
        return null;

    }
}
