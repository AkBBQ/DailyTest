package com.example.mytestdemo.tool;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {

    public static void main(String[] args) {
        int total = 1000000; // 总数量
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);

        bf.put("孙杰");
        boolean b = bf.mightContain("孙2杰");

        System.out.println(b);
    }
}
