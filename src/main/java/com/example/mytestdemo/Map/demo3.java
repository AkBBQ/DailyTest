package com.example.mytestdemo.Map;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Map
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/8/14 4:06 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo3 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("0","0");
        test(map);
        System.out.println(JSON.toJSONString(map));
    }

    public static void test(Map<String,String> map){
        map.put("1","1");
    }
}