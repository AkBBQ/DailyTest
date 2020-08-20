package com.example.mytestdemo.JavaDemo.NullTest;

import com.example.mytestdemo.Model.User;

import java.util.Objects;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.NullTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/24 3:01 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo1 {

    public static void main(String[] args) {
        User user = null;
        if (Objects.nonNull(user.getId())) {
            System.out.println(123);
        }
    }
}