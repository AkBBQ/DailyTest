package com.example.mytestdemo.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.demo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/12 9:13 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class map {
    public static void main(String[] args) {
        List list1=new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List list2=new ArrayList();
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        //从哪个位置添加
        list1.addAll(4,list2);
        list2.add(list1.subList(1,2));

        System.out.println(list1);
        System.out.println(list2);

    }
}