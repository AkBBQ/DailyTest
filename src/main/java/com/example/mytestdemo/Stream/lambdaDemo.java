package com.example.mytestdemo.Stream;
import	java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Stream
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/9/20 3:30 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class lambdaDemo {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();




        Student student1 = new Student();
        student1.setId(1);
        student1.setName("张三");


        Student student2 = new Student();
        student2.setId(2);
        student2.setName("李四");


        List<Student.Teacher> list2 = new ArrayList<>();
        Student.Teacher teacher1 = new Student.Teacher();
        teacher1.setT_name("张老师");
        Student.Teacher teacher2 = new Student.Teacher();
        teacher2.setT_name("李老师");

        list2.add(teacher1);
        list2.add(teacher2);

        student1.setTeachers(list2);
        student2.setTeachers(list2);


        list.add(student1);
        list.add(student2);

        List<Student> ss = list.stream().filter(x -> x.getName().equals("张三")).collect(Collectors.toList());

        System.out.println(ss);

    }

    @Data
    public static class Student{
        private int id;
        private String name;
        private List<Teacher> teachers;

        @Data
        public static class Teacher {
            private String t_name;

        }

    }
}