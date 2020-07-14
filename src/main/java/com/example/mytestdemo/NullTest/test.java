package com.example.mytestdemo.NullTest;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.NullTest
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/7/2 11:37 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class test {


    public static void main(String[] args) {

        //从大到小 3 1 2


        Sun sun1 = new Sun();
        sun1.setId(1);
        //2019-02-18
        sun1.setBir(new Date(1550419200000L));


        Sun sun2 = new Sun();
        sun2.setId(2);
        //2018-12-22
        sun2.setBir(new Date(1545408000000L));


        Sun sun3 = new Sun();
        sun3.setId(3);
        //2019-02-20
        sun3.setBir(new Date(1550592000000L));


        List<Sun> list = new ArrayList<>();
        list.add(sun1);
        list.add(sun2);
        list.add(sun3);

        Collections.reverse(list);


        List<Sun> collect = list.stream().sorted(Comparator.comparing(Sun::getBir)).collect(Collectors.toList());

        list.forEach(s->{
            System.out.println(s);
        });
    }



    @Data
    public static class Sun{
        private int id;
        private Date bir;

    }
}