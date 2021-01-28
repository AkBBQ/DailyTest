package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicInteger 存在ABA问题
 * AtomicReference 能过解决 ABA问题
 */

public class AtomicDemo {

    public static void main(String[] args) {
        AtomicReference<Integer> atomicReference = new AtomicReference<>(0);
        List<String> list = new ArrayList<>();
        list.add("134");
        list.add("134");
        list.add("134");

        list.forEach(x -> {
            atomicReference.set(atomicReference.get() + 1);
        });
        System.out.println(atomicReference.get());
    }
}