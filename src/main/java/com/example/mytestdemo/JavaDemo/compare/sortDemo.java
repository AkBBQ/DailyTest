package com.example.mytestdemo.JavaDemo.compare;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.compare
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/6/22 3:56 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class sortDemo {

    public static void main(String[] args) {

        List<Sunjie> dates = new ArrayList<>();

        Sunjie sunjie = new Sunjie();
        sunjie.setDate("2020-04-03");

        Sunjie sunjie1 = new Sunjie();
        sunjie1.setDate("2011-04-03");

        Sunjie sunjie2 = new Sunjie();
        sunjie2.setDate("2023-04-03");


        Sunjie sunjie3 = new Sunjie();
        sunjie3.setDate("2000-04-03");

        Sunjie sunjie4 = new Sunjie();
        sunjie4.setDate("1998-01-22");


        Sunjie sunjie5 = new Sunjie();
        sunjie5.setDate("2042-01-03");


        dates.add(sunjie);
        dates.add(sunjie1);
        dates.add(sunjie2);
        dates.add(sunjie3);
        dates.add(sunjie4);
        dates.add(sunjie5);


        List<Sunjie> collect = dates.stream().sorted(Comparator.comparing(Sunjie::getDate)).collect(Collectors.toList());

        collect.forEach(System.out::println);

        Sunjie sunjie8 = new Sunjie();
        sunjie8.setDate("2023-04-03");

        System.out.println(sunjie8.getSs() * 3 + "sss");


    }

    @Data
    public static class Sunjie{
        private String date;
        private Integer ss;
    }
}