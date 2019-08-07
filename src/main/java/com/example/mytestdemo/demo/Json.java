package com.example.mytestdemo.demo;

import net.sf.json.JSONObject;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Demo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/6/17 10:29 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class Json {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("man","张三和李四");
        System.out.println("haha"+jsonObject.get("man"));
        System.out.println(jsonObject);
    }
}