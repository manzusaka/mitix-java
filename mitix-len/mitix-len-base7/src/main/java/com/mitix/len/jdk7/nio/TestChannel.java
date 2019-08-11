package com.mitix.len.jdk7.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by oldflame on 2017/4/30.
 * <p>
 * 1.通道（channel）:用于源节点和目标节点的连接  再JAVA NIO中负责缓存区数据的传输  Channel本身不存储数据  要配合缓冲区使用
 * <p>
 * 2.通道接口
 * java.nio.channels.Channel接口
 * |--FileChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * <p>
 * 3.通道获取
 * 1.java 针对支持的通道调用  getChannel()方法
 * <p>
 * 本地IO   FileInputStream/FileInputStream
 * RandomAccessFile
 * <p>
 * 在jdk 1.7  中nio.2的通道channels里面的类中增加了open()方法
 * 在jdk 1.7  中Files工具类的Files工具类的newByteChannel()
 * <p>
 * 4.通道之间的数据传输
 * transferForm
 * transferTo
 * <p>
 * <p>
 * 5.分散(Scatter) 聚集(Gather)
 * 分散读取（Scattering Readers） 将通道中的数据分散到多个缓冲区
 * 聚集写入（Gathering writers）  将多个缓冲区中的数据聚集到一个通道中
 * <p>
 * 6.字符集
 * 编码:将字符串转换成字节数组
 * 解码:将字节数组转换成字符串
 */
public class TestChannel {
    //利用通道完成数据的复制
    @Test
    public void test1() throws FileNotFoundException {
        long start = System.currentTimeMillis();

        FileInputStream iutputStream = new FileInputStream("D:/CHANGES.txt");
        FileOutputStream outputStream = new FileOutputStream("D:/CHANGES2.txt");
        FileChannel inChannel = iutputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        try {
            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outChannel.close();
                inChannel.close();
                iutputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    //使用直接缓冲区完成文件的复制   （内存映射文件）
    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("D:/CHANGES.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("D:/CHANGES3.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            byte[] dst = new byte[inMappedByteBuffer.limit()];
            inMappedByteBuffer.get(dst);
            outMappedByteBuffer.put(dst);

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    //使用直接缓冲区进行分段读取
    @Test
    public void test3() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("D:/CHANGES.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("D:/CHANGES4.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            System.out.println(inChannel.size());

            long maxSize = inChannel.size();
            long bufferSize = 1024;

            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            for (long offset = 0; offset < maxSize; offset += bufferSize) {
                byte[] dst = null;
                if (maxSize - offset >= bufferSize) {
                    dst = new byte[(int) bufferSize];
                    for (int i = 0; i < bufferSize; i++) {
                        byte b = inMappedByteBuffer.get();
                        dst[i] = b;
                    }
                } else {
                    long tmpSize = maxSize - offset;
                    dst = new byte[(int) tmpSize];
                    for (int i = 0; i < maxSize - offset; i++) {
                        byte b = inMappedByteBuffer.get();
                        dst[i] = b;
                    }
                }
                outMappedByteBuffer.put(dst);
            }

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //直接缓冲区分段读取
    @Test
    public void test4() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("D:/CHANGES.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("D:/CHANGES5.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            long bufferSize = 2048;

            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, bufferSize);
            MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);

            while (true) {
                int eof = inChannel.read(inMappedByteBuffer);
                if (eof == -1) {
                    break;
                }
                byte[] dst = null;
                inMappedByteBuffer.get(dst);
                outMappedByteBuffer.put(dst);
            }
            inChannel.close();
            outChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //通道之间的数据传输
    @Test
    public void test5() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("D:/CHANGES.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("D:/CHANGES6.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
            //传输
            inChannel.transferTo(0, inChannel.size(), outChannel);
            //或者这样写
//            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //分散聚集
    @Test
    public void test6() {
        try {
            RandomAccessFile file = new RandomAccessFile("D:/CHANGES.txt", "rw");

            FileChannel channel1 = file.getChannel();
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

            ByteBuffer[] byteBuffers = {byteBuffer1, byteBuffer2};
            channel1.read(byteBuffers);

            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
            }

            System.out.println("-------------------------------------------------");
            System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));
            System.out.println("-------------------------------------------------");
            System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));

            RandomAccessFile file1 = new RandomAccessFile("D:/CHANGES7.txt", "rw");
            FileChannel channel2 = file1.getChannel();
            channel2.write(byteBuffers);


            channel1.close();
            channel2.close();
            file.close();
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //编码和解码
    @Test
    public void test7() {
        try {
            //查看字符集编码
        /*Map<String, Charset> map = Charset.availableCharsets();
        for (String s : map.keySet()) {
            System.out.println(s + "=" + map.get(s));
        }*/
            //编码和解码
//            Charset charset = Charset.forName("GBK");
            Charset charset1 = Charset.forName("UTF-8");

            //获取编码器
            CharsetEncoder encoder = charset1.newEncoder();

            //获取解码器
            CharsetDecoder decoder = charset1.newDecoder();


            CharBuffer charBuffer = CharBuffer.allocate(1024);
            charBuffer.put("我是雷锋！！！！");
            charBuffer.flip();
            //编码
            ByteBuffer byteBuffer = encoder.encode(charBuffer);
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.println(byteBuffer.get());
            }

            //解码
            byteBuffer.flip();
            CharBuffer charBuffer1 = decoder.decode(byteBuffer);
            System.out.println(charBuffer1.toString());


        } catch (Exception e) {

        }


    }
}
