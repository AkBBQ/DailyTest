package com.example.mytestdemo.LeeCode;

//最长子串 滑动窗口写法

import java.util.HashMap;

public class MaxString {

    public static void main(String[] args) {
        String s = "avcader";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //如果发现重复了 需要动左指针的位置为 重复字符串后移一位
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //如果不重复的情况下
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);

        }
        return maxLength;
    }
}
