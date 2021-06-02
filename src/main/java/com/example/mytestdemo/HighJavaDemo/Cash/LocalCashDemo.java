package com.example.mytestdemo.HighJavaDemo.Cash;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class LocalCashDemo {

    public static void main(String[] args) throws Exception {

        Cache<String, String> tenantCache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .removalListener(item->{
                    System.out.println(item.getKey()+"被移除了 原因："+item.getCause());
                })
                .build(); // 缓存有效期 3s

        tenantCache.put("name", "张三");
        tenantCache.put("age", "22");

        String name = tenantCache.getIfPresent("name");
        System.out.println(name);

        Thread.sleep(5000L);
        String age = tenantCache.getIfPresent("age");
        System.out.println(age);
    }
}
