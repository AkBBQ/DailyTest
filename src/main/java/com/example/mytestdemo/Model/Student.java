package com.example.mytestdemo.Model;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Model
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/27 11:01 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;

    public Student(){}

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private String say(Integer id){
        System.out.println("hello"+id);
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}