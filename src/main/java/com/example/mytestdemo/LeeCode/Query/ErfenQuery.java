package com.example.mytestdemo.LeeCode.Query;

import java.util.Arrays;

/**
 * 二分查找发
 *
 * @author angtai
 */

public class ErfenQuery {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 50, 9, 3, 24, 52, 33,77};
        //给数组排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(query(arr, 102));

    }

    public static int query(int[] arr, int date) {
        int min = 0;
        int max = arr.length - 1;

        int i = 1;

        while (min <= max) {
            int mid = (max + min) / 2;
            System.out.println("第"+i+"次循环的中间值为:"+arr[mid]);
            if (date == arr[mid]) {
                i++;
                System.out.println("循环了" + i + "次找到了目标值");
                return arr[mid];

            }
            if (arr[mid] > date) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        return -1;

    }
}