package com.example.mytestdemo.LeeCode.PaiXu;

import java.util.Arrays;

/**
 * 选择排序
 * 每次循环一下数组 把最大或者最小拿出来 和头节点元素进行交换位置
 *
 * @author angtai
 */

public class XuanZe {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 5, 12, 7, 8};
        int[] query = query2(arr);

        System.out.println(Arrays.toString(query));


    }

    public static int[] query(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //最小的索引为第一个
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //如果循环中的数组中有比这个还小的 记录这个值
                    min = j;
                }
            }
            //将arr[i] 和 arr[min]值交换
            //2值交换需要第三个值作为媒介
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }


    public static int[] query2(int[] arr) {

        int[] arr2 = new int[]{1, 4, 2, 5, 12, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            int tempMin = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[tempMin]) {
                    tempMin = j;
                }
            }
            //交换 arr[i] 和 arr[tempMin];
            int temp = arr[i];
            arr[i] = arr[tempMin];
            arr[tempMin] = temp;
        }

        return arr;
    }


}