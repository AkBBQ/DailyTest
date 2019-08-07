package com.example.mytestdemo.StringTest;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.StringTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/26 2:37 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
//        String a = "";
//        if(a != null){
//            System.out.println("123");
//        }


//        if(Objects.nonNull(a)){
//            System.out.println(123);
//        }




        List<String> list = null;


//        System.out.println(list.toString());

        if(CollectionUtils.isEmpty(list)){
            System.out.println("111");

        }
//
//        if(org.apache.commons.lang.StringUtils.isEmpty(list.get(0))){
//            System.out.println("222");
//
//        }
    }
}