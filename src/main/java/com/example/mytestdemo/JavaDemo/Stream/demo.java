package com.example.mytestdemo.JavaDemo.Stream;

import com.example.mytestdemo.Command.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Stream
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/9 4:28 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        List<User> a = new ArrayList();

        a.add(User.builder().age(1).name("a").build());
        a.add(User.builder().age(2).name("b").build());
        a.add(User.builder().age(3).name("c").build());
        a.add(User.builder().age(4).name("d").build());
        a.add(User.builder().age(5).name("e").build());
        a.add(User.builder().age(6).name("f").build());

        //连续使用二个.map也是没问题的
        List<String> collect = a.stream().map(User::getAge).map(String::valueOf).collect(Collectors.toList());
        System.out.println(collect.toString());

    }
}