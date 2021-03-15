package com.example.mytestdemo.JavaDemo.Copy;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Copy
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2021/3/11 8:25 下午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class CopyDemo {
    public static void main(String[] args) {
        //demo1 引用拷贝拷贝 2个栈地址指向一个堆地址
        Student student = new Student(1, "孙姐");
        Student student1 = student;
        System.out.println("引用拷贝1:" + student);
        System.out.println("引用拷贝2:" + student1);

        System.out.println();
        //demo2 浅拷贝
        Hello hello = new Hello(999,"999");
        Teacher teacher = new Teacher(22, hello);
        Teacher teacher1 = (Teacher) teacher.clone();
        System.out.println("浅拷贝1:" + teacher.toString());
        System.out.println("浅拷贝2:" + teacher1.toString());
        //teacher 和 teacher1 是2个不同的对象

       Map map = new ConcurrentHashMap<>();

        Hello hello1 = teacher1.getHello();
        hello1.hashCode();
        hello1.setId(10000);
        hello1.setPhone("10000");
        System.out.println();

        System.out.println("浅拷贝变化之后");
        System.out.println(teacher);
        System.out.println(teacher1);

    }


    /**
     * 普通对象
     */
    @Data
    public static class Student {
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" + this.hashCode() +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    /**
     * 浅拷贝实验对象
     */
    @Data
    public static class Teacher implements Cloneable {
        //基本数据类型
        private int age;
        //引用数据类型
        private Hello hello;

        @Override
        public Object clone() {
            //浅拷贝
            try {
                // 直接调用父类的clone()方法
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        public Teacher(int age, Hello hello) {
            this.age = age;
            this.hello = hello;
        }

        @Override
        public String toString() {
            return "Teacher{" + this.hashCode()+
                    "age=" + age +
                    ", hello=" + hello +
                    '}';
        }
    }

    @Data
    public static class Hello{
        private int id;
        private String phone;

        public Hello(int id, String phone) {
            this.id = id;
            this.phone = phone;
        }
    }
}