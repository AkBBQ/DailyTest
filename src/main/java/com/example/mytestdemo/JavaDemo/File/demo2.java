package com.example.mytestdemo.JavaDemo.File;

import java.io.*;
import java.util.*;


/**
 * 将内容写到文件中
 */

public class demo2 {


    public static void main(String[] args) {
        //新建一个文件
        File file = getFile();
        //要写入的内容
        List<?> list = Arrays.asList(1,2,3,4,5);

        try {
            //将内容转成byte数组
            byte b[];
            b = list.toString().getBytes();
            //输出流到文件中
            FileOutputStream in = new FileOutputStream(file);
            try {
                //写入文件 字节数组，起始位置，长度
                in.write(b,0,b.length);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }




    public static File getFile(){
        File file = new File("/Users/angtai/dev/FileTest","myFile.txt");
        try {
            if(!file.exists()){
                //如果文件不存在就创建一个文件
                file.createNewFile();
                return file;
            }else {
                //如果文件存在
                file.deleteOnExit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}