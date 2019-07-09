package com.example.mytestdemo.OptionalTest;

import java.util.Optional;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.OptionalTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/2 11:07 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo2 {
    public static void main(String[] args) {
        int a =1;

        Optional.ofNullable(a).ifPresent(x->{
            System.out.println(x);
        });
    }
}