package com.example.mytestdemo.NullTest;

import com.example.mytestdemo.Model.User;

import java.util.ArrayList;
import java.util.List;
/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.NullTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/6/28 9:15 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        //set null值没关系 如果在null值的基础上再.操作就会报空指针
//        User user = User.builder().id(1).build();
//        System.out.println("user的姓名是"+user.getName());
//        User user1 =User.builder().build();
//        user1.setName(user.getName());
//        System.out.println("user1"+user1);
//        System.out.println(user.getName().toString());


        User user1 = User.builder().name("一").build();
        User user2 = User.builder().name("二").build();
        User user3 = User.builder().name("三").build();
        User user4 = User.builder().name("四").build();
        User user5 = User.builder().name("五").build();

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);


        List<User> list2 = new ArrayList<>();

        for(User user:list){
            if(user.getName().equals("一")){
                list2.add(user);
            }
        }
        list.removeAll(list2);

        list.forEach(System.out::println);


    }
}