package com.example.mytestdemo.LeeCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeeCode 1
 * 求2数之和的下标
 * [2,7,11,15]
 * 9
 */

public class SumOfTwoNum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 4};
        solution.twoSum1(nums, 6);
        int[] ints = solution.twoSum2(nums, 6);
        for (int i : ints) {
            System.out.println("ha:" + i);
        }
    }

    static class Solution {

        //方法一 暴力 我的第一遍解法
        public int[] twoSum1(int[] nums, int target) {
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                    }

                }

            }

            for (int i : result) {
                System.out.println(i);
            }
            return result;
        }

        //大神答案
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //第二步 如果找到key了 那么把key的地址 + key2的地址都拿出来
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
                //第一步 将想要的的值作为key value记录当前key2的地址
                map.put(target - nums[i], i);
            }
            return null;
        }
    }
}