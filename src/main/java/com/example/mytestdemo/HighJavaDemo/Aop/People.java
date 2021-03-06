package com.example.mytestdemo.HighJavaDemo.Aop;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.Aop
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/5/19 10:21 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Data
public class People {
    String name;
    String age;
    String phone;
    int size;

    public People(String name, String age, String phone,int size) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.size = size;
    }

    public People() {
    }
}