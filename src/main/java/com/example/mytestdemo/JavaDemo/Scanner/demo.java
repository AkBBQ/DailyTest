package com.example.mytestdemo.JavaDemo.Scanner;

import com.example.mytestdemo.Command.User;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Scanner
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/27 10:17 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
//        com.example.mytestdemo.Scanner scan = new com.example.mytestdemo.Scanner(System.in);	//构造Scanner类的对象scan，接收从控制台输入的信息
//        System.out.println("请输入学生的姓名,以逗号隔开");
//        String name = scan.nextLine();//接收一个字符串，可以加除Enter以外的所有符号，包括空格和Tab
//        System.out.println(name);
//        String[] arr = name.split(",");
//        System.out.println(arr.length);


//        while(scan.hasNextLine()) {// hasNextLine()方法判断当前是否有输入，当键盘有输入后执行循环
//            if(scan.hasNextInt()) {// 判断输入的值是否为整数类型，当为整数类型时执行循环
//                System.out.println("你输入的姓名为："+name);
//                break;
//            }else {
//                System.out.println("请输入数字哦！");
//                continue;
//            }
//        }


        Map<String,Object> map1 = new HashMap<>();
        map1.put("学号",1);
        map1.put("姓名","张三");
        map1.put("电话","110");
        map1.put("地址","南京");
        System.out.println(map1);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("学号",11);
        map2.put("姓名","张三1");
        map2.put("电话","1101");
        map2.put("地址","南京1");
        System.out.println(map2);

        List list =new ArrayList();
        list.add(map1);
        list.add(map2);
        System.out.println(list);


        User user = User.builder()
                .id(1)
                .name("张三")
                .age(12)
                .dead(true)
                .build();
        System.out.println(user);








    }
}