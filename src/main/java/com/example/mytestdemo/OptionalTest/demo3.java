package com.example.mytestdemo.OptionalTest;

import lombok.Data;
import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.OptionalTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/8/21 10:27 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo3 {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        Student.School school = new Student.School();
        school.setTeacher("孙杰");
        student.setSchool(school);
        System.out.println(student);

        String s = Optional.ofNullable(student)
                .map(Student::getSchool)
                .map(Student.School::getTeacher).orElse("无");
        System.out.println(s);
    }

    @Data
    public static class Student{
        public Integer id;
        public String name;
        public School school;

      @Data
      public static class School{
          public Integer idd;
          public String teacher;
      }
    }
}