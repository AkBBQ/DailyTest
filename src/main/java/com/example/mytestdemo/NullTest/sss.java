package com.example.mytestdemo.NullTest;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.NullTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/7/2 8:05 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class sss {
    public static void main(String[] args) {
    JIE j = new JIE();

       // System.out.println(j.getAge());

//        if(j.getName().equals(0L)){
//            System.out.println(11);
//        }

        if(Long.valueOf(0).equals(j.getName())){
            System.out.println(122);
        }

    }





    @Data
    public static class JIE{
        private Integer age;
        private Long name;

        public JIE() {
            this.age = 50;
        }
    }
}