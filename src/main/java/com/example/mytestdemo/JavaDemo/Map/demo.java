package com.example.mytestdemo.JavaDemo.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Map
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/6/28 3:32 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        Integer i;
        for(i=0;i<=2;i++){
        map1.put(i,"哈哈");
        map2.putAll(map1);
        }
    }
}