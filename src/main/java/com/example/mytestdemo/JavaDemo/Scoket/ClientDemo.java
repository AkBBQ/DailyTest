package com.example.mytestdemo.JavaDemo.Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 2 后启动客户端
 *
 * @author angtai
 */

public class ClientDemo {
    private static  final  String host="localhost";
    public static void main(String[] args) {
        try {
            // 创建 Socket 用来发起请求，设置请求 IP 为本机，端口号为 8080
            Socket socket = new Socket(host,8080);
            // 通过 Socket 的流对象创建 PrintWriter 用于发送请求数据，创建 BufferedReader 用于接收服务端响应数据
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 发送数据
            String requestData = " 客户端请求数据 ";
            printWriter.println(requestData);
            printWriter.flush();
            // 接收服务端响应数据
            String responseData = bufferedReader.readLine();
            System.out.println(" 接收到服务端的响应数据为： " + responseData);

            // 关闭资源
            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}