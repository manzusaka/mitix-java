package com.mitix.len.jdk7.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by oldflame on 2017/4/30.
 * <p>
 * 一.使用NIO完成通信的三个核心
 * 1.通道（Channel）：负责连接
 * java.nio.channels.Channel
 * |--SelectableChannel
 * |---SocketChannel
 * |---ServerSocketChannel
 * |---DatagramChannel
 * <p>
 * |---Pipe.SinkChannel
 * |---Pipe.SourceChannel
 * <p>
 * 2.缓冲区（Buffer）:负责存取数据
 * 3.选择器（Selector）：是SelectableChannel的多路复用器  用于SelectableChannel的IO状况
 */
public class ExpBlockingNIO2 {
    //客户端
    @Test
    public void client() {
        try {
            //获取通道
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9080));

            FileChannel fileChannel = FileChannel.open(Paths.get("D:/CHANGES.txt"), StandardOpenOption.READ);

            //分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //读取本地文件，发送到服务端
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }

            //这个时候没办法决定是否已经发完  所有需要这样确定
            //socketChannel.shutdownOutput();

            //接受反馈
            int len = 0;
            while ((len = socketChannel.read(buffer)) != -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, len));
                buffer.clear();
            }

            fileChannel.close();
            socketChannel.close();

        } catch (Exception e) {

        }
    }

    //服务端
    @Test
    public void server() {

        try {
            //获取通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            FileChannel outChannel = FileChannel.open(Paths.get("D:/CHANGES11.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            //2.绑定数据
            serverSocketChannel.bind(new InetSocketAddress(9080));

            //获取客户链接的通道
            SocketChannel channel = serverSocketChannel.accept();

            //接受客户端数据保存到本地
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }

            byteBuffer.put("服务端接收数据成功".getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);

            channel.close();
            outChannel.close();
            serverSocketChannel.close();

        } catch (Exception e) {

        }

    }

}
