package com.example.mytestdemo.JavaDemo.Set;

import java.util.HashSet;
import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Set
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/6/28 11:33 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        List<String> ss = new ArrayList<>();
        ss.add("aa");
        ss.add("aa");
        ss.add("bb");

        System.out.println(ss);

        //list转Set
        Set<String> hh = new HashSet<>(ss);
        System.out.println(hh);

        Set<String> s =new HashSet<>();
        s.add("123");
        s.add("123");
        s.add("456");
        System.out.println(s);
    }
}