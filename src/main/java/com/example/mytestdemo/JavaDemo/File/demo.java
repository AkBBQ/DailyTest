package com.example.mytestdemo.JavaDemo.File;

import java.io.*;
/**
 * 文件写入测试类
 */

public class demo {
    public static void main(String[] args) {
        // file(内存)----输入流---->【程序】----输出流---->file(内存)
        File file = new File("/Users/angtai/dev/FileTest", "test.txt");
        try {
            if(!file.isDirectory()){
            // 文件不存在的话,创建改文件
            file.createNewFile();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 向文件写入内容(输出流)
        String str = "亲爱的小南瓜！";
        byte bt[] = new byte[1024];
        bt = str.getBytes();
        try {
            //写入文件
            FileOutputStream in = new FileOutputStream(file);
            try {
                in.write(bt, 0, bt.length);
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            //未找到文件
            e.printStackTrace();
        }
        try {
            // 读取文件内容 (输入流)
            FileInputStream out = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(out);
            int ch = 0;
            while ((ch = isr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
