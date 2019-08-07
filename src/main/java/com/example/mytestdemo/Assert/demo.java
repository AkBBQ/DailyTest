package com.example.mytestdemo.Assert;

import com.example.mytestdemo.Model.User;
import org.springframework.util.Assert;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Assert
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/11 4:50 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {

    public static void main(String[] args) {
        try {
            test();
            System.out.println("123");
        } catch (Exception e) {
//            throw new RuntimeException("捕获异常,之后的代码不执行");
            System.out.println("123");
        }
    }

    public static void test(){
        User user = null;
        Assert.notNull(user,"user不能为空");
        System.out.println(123);
    }
}