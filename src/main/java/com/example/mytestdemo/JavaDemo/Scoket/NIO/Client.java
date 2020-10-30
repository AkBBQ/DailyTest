package com.example.mytestdemo.JavaDemo.Scoket.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Nio客户端
 */

public class Client {
    public static void main(String[] args) throws IOException {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //如果连接上通道的话
        if (socketChannel.isConnected()) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他工作。。。。");
            }

            String str = "服务端,这里是客户端一 收到请回复";
            //字节流缓冲区
            ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
            //发送数据将buffer数据写入到 channel
            socketChannel.write(byteBuffer);
            System.in.read();
        }
    }
}