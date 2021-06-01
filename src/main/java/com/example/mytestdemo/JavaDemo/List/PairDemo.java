package com.example.mytestdemo.JavaDemo.List;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Pair只能存放一对Key Value
 */
public class PairDemo {

    public static void main(String[] args) {
        Pair<String, String> of = Pair.of("hello", "tom");
        String left = of.getLeft();
        String right = of.getRight();
        System.out.println(left);
        System.out.println(right);
    }
}
