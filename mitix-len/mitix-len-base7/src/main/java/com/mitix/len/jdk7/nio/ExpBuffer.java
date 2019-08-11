package com.mitix.len.jdk7.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by oldflame on 2017/4/29.
 * <p>
 * <p>
 * 1.一个用于特定基本类型数据的容器,在java NIO中负责数据存储。缓冲区就是数组。
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 上述缓冲区的管理方式几乎一致   通过allocate获取缓冲区
 * <p>
 * 2.缓冲区存储数据的核心方法
 * put()   存
 * get()   取
 * <p>
 * <p>
 * 3.缓冲区的四个属性
 * capacity  容量
 * limit     界限  表示缓冲区中可以操作数据的大小（limit后面的数据是不能进行读写的）
 * position  缓冲区中正在操作数据的位置   position<=limit<=capacity
 * mark      标记位置  可以记录刚才缓冲区的位置   然后调用resert方法可以返回原来的地方
 * <p>
 * <p>
 * 4.直接缓冲区和非直接缓冲区
 * 传统的IO和通过allocate获取缓冲区   非直接缓冲区
 * NIO  allocateDirect  可以通过这个方法创建直接缓冲区   内存映射文件
 */
public class ExpBuffer {

    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //初始
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capacity=" + buffer.capacity());
        //进行第一次数据操作  数据的写模式
        String str = "asssss";
        buffer.put(str.getBytes());
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capacity=" + buffer.capacity());
        //切换到读取数据的模式
        buffer.flip();
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capacity=" + buffer.capacity());
        //读取缓冲区中的数据
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println(new String(bytes));

        //可以重复读数据
        buffer.rewind();
        bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println(new String(bytes));

        //进入数据被遗忘状态  不能正确读写状态  但是里面的数据应该还在的
        buffer.clear();
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println((char) buffer.get());
    }


    //测试remark
    @Test
    public void test2() {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String str = "plmokj";
        buffer.put(str.getBytes());

        //转换状态
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes, 0, 2);
        System.out.println(new String(bytes));
        System.out.println(buffer.position());

        //标记目前的position位置
        buffer.mark();
        buffer.get(bytes, 2, 2);
        System.out.println(new String(bytes));
        System.out.println(buffer.position());

        buffer.reset();
        System.out.println(buffer.position());

    }
}
