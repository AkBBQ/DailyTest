package com.example.mytestdemo.LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * [2,7,11,15]
 *
 * 9
 */

public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 4};
        solution.twoSum1(nums, 6);
        int[] ints = solution.twoSum2(nums, 6);
        for(int i:ints){
            System.out.println("ha:"+i);
        }
    }

    static class Solution {

       //我的第一遍解法
        public int[] twoSum1(int[] nums, int target) {
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1;j< nums.length;j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                    }

                }
            }

            for(int i:result){
                System.out.println(i);
            }
            return result;
        }

        //大神答案
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }

        public boolean isPossible(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {

                }
                map.put(nums[i], i);

            }

            return false;
        }
    }
}