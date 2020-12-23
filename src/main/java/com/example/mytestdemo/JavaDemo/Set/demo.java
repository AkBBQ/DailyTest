package com.example.mytestdemo.JavaDemo.Set;

import com.example.mytestdemo.HighJavaDemo.Aop.People;
import com.example.mytestdemo.JavaDemo.Stream.testDemo.Student;

import java.math.BigDecimal;
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

        int a =10;
        int b = 20;
        int c = 30;
        //只要是姓名和手机号码一样 我们就认为是一个人
        People p1 = new People("zhangsan","20","1525",1);
        People p2 = new People("zhangsan","20","1525",1);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p2.hashCode());




    }
}