package com.example.mytestdemo.JavaDemo.OptionalTest;

import com.example.mytestdemo.Model.User;

import java.util.Optional;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.OptionalTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/6/26 3:38 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        User user = User.builder().age(12).name("张三").build();
        System.out.println(user);


    Optional.ofNullable(user.getId()).ifPresent(x->{
            System.out.println("这个值不为空哦");
        });

        Integer integer =Optional.ofNullable(user.getId()).orElse(2);
        System.out.println("新的user"+user+"结果为"+integer);
    }
}