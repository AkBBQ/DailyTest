package com.example.mytestdemo.LeeCode;

/**
 * 买彩票的最佳时机 leeCode 121
 */

public class BuyCaiPiao {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
        System.out.println(maxPort2(arr));


    }

    //方法一 暴力循环
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > 0) {
                    int temp = prices[j] - prices[i];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    //方法二 记录最低点 然后在最低点后面每天的价格-最低点的最大值做比较
    public static int maxPort2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    //方法二 一般写法
    public static int maxPort3(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                //记录当前最小值
                min = prices[i];
                //算出在当前最小值后面的差值最大值
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}