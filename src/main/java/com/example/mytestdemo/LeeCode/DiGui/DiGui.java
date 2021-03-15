package com.example.mytestdemo.LeeCode.DiGui;

/**
 * 求N的阶乘
 * 5! = 5*4*3*2*1
 */

public class DiGui {

    public static void main(String[] args) {
        System.out.println(Fun(5));


    }

    private static int Fun(int n) {
        if (n == 1){
            return 1;
        }
        return n*Fun(n-1);

    }

}