package com.example.mytestdemo.compare;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.compare
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/6/22 3:56 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class Demo2 {

    public static void main(String[] args) {


        List<String> sun = new ArrayList<>();

        sun.add("1");
        sun.add("2");
        sun.add("3");
        sun.add("4");

        List<String> list = sun.subList(0, 3);


        list.forEach(System.out::println);


        String s1 = "123";
        String s2 = "123";
        String s3 = "123孙姐";

        System.out.println(isContainChinese(s3));
    }




    /**
     * 判断String中是否包含中文
     * @param str
     * @return
     */
    public  static boolean isContainChinese(String str) {

        Pattern p = compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }


}