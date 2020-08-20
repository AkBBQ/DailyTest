package com.example.mytestdemo.JavaDemo.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Map
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/24 2:40 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo2 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,21);
        map.put(3,31);
        map.put(4,41);
        map.put(5,51);
        map.put(6,61);
        System.out.println(map.keySet());
        System.out.println(map.values());


        for(Integer key:map.keySet()){
            if(2 == key){
//              continue;
                break;
            }else{
                System.out.println("哈哈");
            }

        }


        if(!map.containsValue(21)){
            System.out.println("haha");
        }


    }
}