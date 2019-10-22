package com.example.mytestdemo.Stream;
import	java.util.stream.Collectors;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Stream
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/9/20 3:50 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class testDemo {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("张三");

        Student student2 = new Student();
        student2.setName("李四");

        Student student3 = new Student();
        student3.setName("王五");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        System.out.println(JSON.toJSONString(list));

        Student ss = list.stream().filter(x -> x.getName().equals("张三1")).findFirst().orElse(null);
        if(Objects.nonNull(ss)){
        System.out.println(ss);

        }else {
            System.out.println("x");
        }



    }

    @Data
    public static class Student {
        private String name;
    }

}