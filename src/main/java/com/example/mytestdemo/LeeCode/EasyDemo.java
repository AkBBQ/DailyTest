package com.example.mytestdemo.LeeCode;

/**
 * 判断一个数是不是质数(素数)
 * 质数只能被1和它自己本身整除
 *
 * @author sunjie
 */
public class EasyDemo {

    public static void main(String[] args) {
        int a = 6;
        //从2到n-1 看看能不能被整除
        for (int i = 2; i < 5; i++) {
            if (a % i == 0) {
                System.out.println("a不是质数");
                break;
            }
        }
    }
}
