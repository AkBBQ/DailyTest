package com.example.mytestdemo.FanXing;

import lombok.Data;

/**
 * 泛形测试
 * @param <T>
 */

@Data
public class MyTestdemo<T> {
    private String name;
    private Integer id;


    public T student;

    @Data
    public static class Student{
        private String age;
    }

    @Data
    public static class Student2{
        private String love;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge("22");

        Student2 student2 = new Student2();
        student2.setLove("唱歌");

        MyTestdemo demo = new MyTestdemo();
        demo.setStudent(student);
        demo.setId(1);
        demo.setName("22");
        System.out.println(demo);

        MyTestdemo demo2 = new MyTestdemo();
        demo2.setStudent(student2);
        demo2.setId(1);
        demo2.setName("22");
        System.out.println(demo2);



    }
}