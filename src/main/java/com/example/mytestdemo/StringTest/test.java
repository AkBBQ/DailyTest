package com.example.mytestdemo.StringTest;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.StringTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/9/30 10:51 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class test {
    public static void main(String[] args) {
        int dd = 0;
        int ss = 0;

        for(int i = 0; i< 100 ;i++){
            dd=i;
            ss =100 -i;
        if(dd*3+ss/3 == 100 && dd+ss ==100){
            System.out.println("大人数量"+dd);
            System.out.println("小孩数量"+ss);

        }
        }
    }
}