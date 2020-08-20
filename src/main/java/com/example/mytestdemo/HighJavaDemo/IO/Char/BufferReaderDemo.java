package com.example.mytestdemo.HighJavaDemo.IO.Char;

import java.io.*;

/**
 * 缓冲流
 *
 * 读取文件内容可以保持文件内容的格式
 *
 * 整行读取
 *
 */

public class BufferReaderDemo {

    public static void main(String[] args) {
        File file =new File("/Users/angtai/dev/FileTest/charTest.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            //获取字节输入流
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            //获取字符输入流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //整行读取
            String line = null;

            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}