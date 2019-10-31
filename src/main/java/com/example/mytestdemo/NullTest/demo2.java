package com.example.mytestdemo.NullTest;

import com.example.mytestdemo.Model.User;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.NullTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/25 1:47 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo2 {
    public static void main(String[] args) {
        User user = User.builder().dead(true).build();
        if(Boolean.TRUE.equals(user.getDead())){
            System.out.println("true");

        }        System.out.println(user);

        if(user.getId() == null){
            System.out.println(123);

        }    }
}