package com.example.mytestdemo.JavaDemo.demo;

import java.util.Calendar;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.GetReflectDemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/26 4:18 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class DateTest {
    public static void main(String[] args) {
        Long date =1553587374L ;
        Date date1 = new Date(date);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        //System.out.println(c.getTime());

        //获取当前时间的时间戳
       Long dd =new Date().getTime();
        System.out.println(dd);

    }
}