package com.example.mytestdemo.LeeCode.PaiXu;

import java.util.Arrays;

/**
 * 冒泡排序
 */

public class MaoPao {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 11, 412, 451, 212341, 53221, 215, 21412512};
        int[] paixu = paixu(arr);
        System.out.println(Arrays.toString(paixu));
    }

    public static int[] paixu(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}