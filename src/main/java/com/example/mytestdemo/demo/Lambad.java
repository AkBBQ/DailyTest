package com.example.mytestdemo.demo;

import com.example.mytestdemo.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.demo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/22 10:21 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class Lambad {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .id(1)
                .name("孙杰")
                .age(22)
                .build());
        users.add(User.builder()
                .id(2)
                .name("张三")
                .age(21)
                .build());
        users.add(User.builder()
                .id(3)
                .name("孙杰")
                .age(24)
                .build());

        //一条用户ID对应一条记录
        Map<Integer, User> collect = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        //用户Id的集合
        List<Integer> collect1 = users.stream().map(User::getId).collect(Collectors.toList());
        //过滤id大于2的用户
        List<User> collect2 = users.stream().filter(x -> x.getId() > 2).collect(Collectors.toList());
        //累加某个值
        Integer reduce = users.stream().map(x -> x.getId()).reduce(Integer.valueOf(0), Integer::sum);
        //根据用户姓名分组
        Map<String, List<User>> collect3 = users.stream().collect(Collectors.groupingBy(User::getName));

        System.out.println(collect3);
    }
}