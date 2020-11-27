package com.example.mytestdemo.JavaDemo.NullTest;

import java.util.concurrent.CompletableFuture;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.NullTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/11/16 2:29 下午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */


public class StringUtilsDemo {
    public static void main(String[] args) {

        try {
            CompletableFuture.runAsync(()->{
                throw new RuntimeException("123");
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("老子哈哈");
        }
    }
}