package com.example.mytestdemo.HighJavaDemo.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 使用 BufferedReader 从字符文件中读取明文内容
 */

public class BufferedReaderDemo {
    public static void main(String[] args) {

        File file = new File("/Users/angtai/dev/FileTest/test.txt");
        try {
            //读取文件内容 写到jvm内存中
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            int line = 1;
            //每次读取一行
            while ((str  = reader.readLine())!= null){

            System.out.println("第"+line+++"行的内容为:"+str);
           }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}