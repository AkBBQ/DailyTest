package com.example.mytestdemo.JavaDemo.Scoket.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO 客户端
 * ByteBuffer 缓冲区、Selector 多路复用器、channel
 *
 * 多个channel注册搭配Selector
 */

public class Server {
    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个Selector对象 多路复用器
        Selector selector = Selector.open();
        //绑定一个端口号
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 6666));
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到 selector上，关心的事件为 OP_ACCEPT
        //SelectionKey，表示 Selector 和网络通道的注册关系, 共四种:
        //int OP_ACCEPT：有新的网络连接可以 accept，值为 16
        //int OP_CONNECT：代表连接已经建立，值为 8
        //int OP_READ：代表读操作，值为 1
        //int OP_WRITE：代表写操作，值为 4
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端的连接
        while (true) {
            if (selector.select(50000) == 0) {
                System.out.println("服务器50s内没客户端连接,继续等待中.....");
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //根据key对应的通道发生的事件左相应的处理
                if (key.isAcceptable()) { // 如果是OP_ACCEPT 有新的客户端连接
                    //为该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成了一个 socketchannel : " + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector 关注的事件为OP_READ 同事给socket关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接后注册的selectionKey 数量：" + selector.keys().size());

                }
                if (key.isReadable()) { //发生 OP_READ
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到该channel关联的buffer缓冲区
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端 " + new String(buffer.array()));
                }
                //手动从集合中移除当前的selectionKey,防止重复操作
                iterator.remove();
            }
        }
    }
}