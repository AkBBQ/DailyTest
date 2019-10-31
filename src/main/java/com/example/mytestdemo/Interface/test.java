package com.example.mytestdemo.Interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Interface
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/17 1:54 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class test {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap();
        map.put(1,"haha");
        Optional o =Optional.ofNullable(null);
        Object o1 = o.map(s -> 1).orElse(2);
        System.out.println(o1);
    }
}