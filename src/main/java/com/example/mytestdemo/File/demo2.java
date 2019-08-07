package com.example.mytestdemo.File;

import java.io.*;
import java.util.*;


/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.File
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/17 10:53 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo2 {


    public static void main(String[] args) {
        File file = getFile();
        List<?> list = Arrays.asList(1,2,3,4,5);

        try {

            byte b[] = new byte[1024];
            b = list.toString().getBytes();

            //写入文件
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