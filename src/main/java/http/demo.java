package http;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 后台发送短信http请求
 */

public class demo {
    public static void main(String[] args) {

        String URL = "https://open.maihaoche.net/fh/examineResultNotify";

        JSONObject obj = new JSONObject();

        obj.put("uniqueId","123");
        obj.put("paymentDetails",null);


//发送请求
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("MerId", "test-merid");
            connection.setRequestProperty("SecretKey", "test-merid");
            connection.setRequestProperty("SignedMsg", "PC0nRwLc0Vj+UCQUFcs4jDns3DK3LPYkCOGFjP5MRHl3QhO7VxVqGjAe6YZZOeYIqnGRtNz7MebQv5vsS75fAepnX+ZIrIHwDvDrx3eFni2pSRPUBBV2aGpVLKEUbZ/PtizTxLY/x53UMZre8dDdTzSugmGtXVbF2o7/6R9pKViPn4QttgNRdbLRrIMnSSHbFT/a23WhT9I+pkHyfQE3MPim1Uj+MV9ZZeX5JBqhHifLUaiQK6HukHcCh1nOmUeBgVi+VmnM5KrPPzXhtqeZ3yKjavVIhLDchtoREQ6HvCAbgY+Mg+drzz8ySz251D+2bNPKwa1JoX6x3gL6NjR4Gg==");
            //转换为字节数组
            byte[] data = (obj.toString()).getBytes();
            // 设置文件长度
            connection.setRequestProperty("Content-Length", String.valueOf(data.length));

            // 开始连接请求
            connection.connect();
            OutputStream out = connection.getOutputStream();
            // 写入请求的字符串
            out.write((obj.toString()).getBytes());
            out.flush();
            out.close();

            System.out.println(connection.getResponseCode());

            // 请求返回的状态
            if (connection.getResponseCode() == 200) {
                System.out.println("连接成功");
                // 请求返回的数据
                InputStream in = connection.getInputStream();
                String a = null;
                try {
                    byte[] data1 = new byte[in.available()];
                    in.read(data1);
                    // 转成字符串
                    a = new String(data1);
                    System.out.println(a);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                System.out.println("no++");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}