package com.example.mytestdemo.BigDecimal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.BigDecimal
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/2 11:09 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        Test test = new Test();

        List<Test1> test1s = new ArrayList<>();
        Test1 test1 = new Test1();
        test1.setMoney(new BigDecimal("60000.00000000"));
        test1s.add(test1);

        Test1 test2 = new Test1();
        test2.setMoney(new BigDecimal("63000.00000000"));
        test1s.add(test2);
        test.setTest1s(test1s);

        System.out.println("60000金额为:"+test1.getMoney().multiply(new BigDecimal("0.0745")).multiply(new BigDecimal("100")).divide(new BigDecimal("365"), 2, RoundingMode.CEILING));
        System.out.println("63000金额为:"+test2.getMoney().multiply(new BigDecimal("0.0745")).multiply(new BigDecimal("100")).divide(new BigDecimal("365"), 2, RoundingMode.CEILING));

        System.out.println("------------");

        System.out.println("60000精确到分金额为:"+test1.getMoney().multiply(new BigDecimal("0.0745")).multiply(new BigDecimal("100")).divide(new BigDecimal("365"), 2, RoundingMode.CEILING).longValue());
        System.out.println("60000精确到分金额为:"+test2.getMoney().multiply(new BigDecimal("0.0745")).multiply(new BigDecimal("100")).divide(new BigDecimal("365"), 2, RoundingMode.CEILING).longValue());

        System.out.println("总金额为:"+test.getTest1s().stream().mapToLong(asset -> asset.getMoney().multiply(new BigDecimal("0.0745")).multiply(new BigDecimal("100")).divide(new BigDecimal("365"), 2, RoundingMode.CEILING).longValue()).sum());


        long sum = test.getTest1s().stream().mapToLong(asset -> asset.getMoney().multiply(new BigDecimal("0.0745")).multiply(new BigDecimal("100")).divide(new BigDecimal("365"), 2, RoundingMode.CEILING).longValue()).sum();
        System.out.println(sum * 30);

    }

    @Data
    public static class Test {
        private List<Test1> test1s;

    }

    @Data
    public static class Test1 {
        private String name;
        private BigDecimal money;


    }
}