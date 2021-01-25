package com.example.mytestdemo.Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 将图片 、文件 从URL中获取文件字节数组 并且保存到本地中
 */

public class DownLoadFromUrlUtil {

    public static void downAndSaveFile(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = connection.getInputStream();

        //将读到的文件转成byte数组

        byte[] readBuffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(readBuffer)) != -1) {
            byteArrayOutputStream.write(readBuffer, 0, len);
        }
        byteArrayOutputStream.close();


        //读到的文件内容
        byte[] readBytes = byteArrayOutputStream.toByteArray();

        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        //创建文件
        File file = new File(saveDir + File.separator + fileName);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(readBytes);
        fileOutputStream.close();

    }

    public static void main(String[] args) throws IOException {
        downAndSaveFile("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3363295869,2467511306&fm=26&gp=0.jpg", "老猫咪", "/Users/angtai/dev/FileTest/PDFDemo");
    }

}