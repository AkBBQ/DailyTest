package com.example.mytestdemo.HighJavaDemo.IO.Byte;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节流 输入流
 */

public class ByteInputDemo {
    public static void main(String[] args) {
        File file = new File("/Users/angtai/dev/FileTest/myTest.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {


            //读取方法一(比较慢)

            //字节流的子类 输入流也就是读取
            FileInputStream fileInputStream = new FileInputStream(file);

//            //read的读取方式为一个个的读取，也就是说你每调用一次read就会读取下一个字节
//            int read = fileInputStream.read();
//            //read的返回值为-1说明文件读取完毕
//            while (read > 0) {
//                System.out.println((char) read);
//                read = fileInputStream.read();
//            }

            //读取方法二

            //1kb
            byte[] bytes = new byte[1024];
            //以一个kb的方式去读取，如果文本内容不超过一个kb的话就会全部读取，将读取到的内容放在byte数组中并且返回文本内容的字节数
            int read1 = fileInputStream.read(bytes);
            String content = new String(bytes);
            System.out.println("content:"+content);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}