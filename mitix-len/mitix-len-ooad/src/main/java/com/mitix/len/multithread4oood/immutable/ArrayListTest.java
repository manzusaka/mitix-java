package com.mitix.len.multithread4oood.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/4/7
 * ${DESCRIPTION}
 * 测试非线程安全的arraylist
 */
public class ArrayListTest {


    public static void main(String[] args) {
        //直接使用list会没有安全性
        //List<Integer> list = new ArrayList<>();
        //测试使用下面方式
        final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        new WriteThread(list).start();
        new ReadThread(list).start();


    }

    static class WriteThread extends Thread {

        private final List<Integer> list;

        public WriteThread(List<Integer> list) {
            super("WriteThread");
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; ; i++) {
                list.add(i);
                list.remove(0);
            }
        }
    }

    static class ReadThread extends Thread {

        private final List<Integer> list;

        public ReadThread(List<Integer> list) {
            super("WriteThread");
            this.list = list;
        }

        @Override
        public void run() {
            for (; ; ) {
                //对于list的读取加上了synchronized同步
                synchronized (list) {
                    for (int n : list) {
                        System.out.println(n);
                    }
                }
            }
        }
    }

}
