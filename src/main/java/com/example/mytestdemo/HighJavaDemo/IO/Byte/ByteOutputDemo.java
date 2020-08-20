package com.example.mytestdemo.HighJavaDemo.IO.Byte;

import java.io.*;

/**
 * 字节流父类接口 InputStrem和OutputStrem
 * 字节流 输出流
 */

public class ByteOutputDemo {
    public static void main(String[] args) {
        File file = new File("/Users/angtai/dev/FileTest/out.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
           //字节数组中 放入一些字节
            byte[] bytes = new byte[]{'2', '3'};

            // 写入文本
            fileOutputStream.write(bytes);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bytes);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}