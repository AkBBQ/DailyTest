package com.example.mytestdemo.JavaDemo.Scoket.BIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO 同步阻塞IO
 * 1 先启动服务器
 */

public class ServeDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            // 调用 accept() 方法监听客户端请求，该方法是阻塞方法，程序会停留在这里直到有客户端请求服务端的8080 接口
            //Socket 用于通信中的数据传输
            Socket socket = serverSocket.accept();
            //从socket中拿到输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String requestData = bufferedReader.readLine();
            System.out.println("请求数据为:" + requestData);

            // 创建 PrintWriter 发送服务端响应数据，接收数据流对象也来自 Socket
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            // 写入响应数据
            printWriter.println(" 服务端已接收到你的请求，响应数据为（服务端响应数据）！ ");
            // 使用 flush() 方法强制发送数据而不是等到缓冲区满了后才发送
            printWriter.flush();
            // 关闭资源
            printWriter.close();
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}