package com.example.mytestdemo.HighJavaDemo.Reflect;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Student {

    private int age = 1;

    private String name ="张三";

    private String phone ="122";

    public Student(int age, String name, String phone) {
        this.age = age;
        this.name = name;
        this.phone = phone;
    }

    public Student(String name) {
        this.name = name;
    }
}