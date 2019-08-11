package com.mitix.len.jdk7.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

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
public class ExpNoBlockingNIO {
    //客户端
    @Test
    public void client() {
        try {
            //获取通道
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9080));

            socketChannel.configureBlocking(false);

            //分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //发送数据
            buffer.put(new Date().toString().getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            //关闭
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
            //设置非阻塞模式
            serverSocketChannel.configureBlocking(false);

            //2.绑定数据
            serverSocketChannel.bind(new InetSocketAddress(9080));
            //获取选择器
            Selector selector = Selector.open();
            //注册选择器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //轮询式获取当前已经“准备就绪的”事件
            while (selector.select() > 0) {
                //获取已经注册的监听事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //迭代
                while (iterator.hasNext()) {
                    //获取准备就绪的事件
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        //获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        //切换非阻塞模式
                        socketChannel.configureBlocking(false);

                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = socketChannel.read(byteBuffer)) > 0) {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(), 0, len));
                            byteBuffer.clear();
                        }
                    }

                }

                iterator.remove();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
