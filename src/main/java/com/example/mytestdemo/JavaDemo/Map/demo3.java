package com.example.mytestdemo.JavaDemo.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * map.getOrDefault 方法使用
 */

public class demo3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("sun", 1);
        map.put("sun", map.getOrDefault("sun", 0) + 1);
        map.put("zhang", map.getOrDefault("su", 0) + 1);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.forEach(item -> {
            System.out.println(item.getKey() + ":" + item.getValue());
        });
    }
}