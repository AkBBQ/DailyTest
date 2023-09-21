package com.example.mytestdemo.java8;

import lombok.Builder;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<String, String> s = (s1 -> s1.substring(0, 4));
        String apply = s.apply("123456789");
        System.out.println(apply);
        
        String name = "张三";
        Student student = get(name, function -> getStudentInfoByName(name));
    }

    @Builder
    public static class Student {
        private final String name;
        private final Integer age;
    }


    //进来string 出去student
    public static Student get(String name, Function<String, Student> function) {
       return function.apply(name);

    }

    public static Student getStudentInfoByName(String name) {
        return Student.builder().name("张三").age(12).build();
    }

}
