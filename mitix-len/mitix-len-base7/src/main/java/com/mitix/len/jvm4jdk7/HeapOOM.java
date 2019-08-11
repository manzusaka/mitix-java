package com.mitix.len.jvm4jdk7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/1/25
 * 堆内存溢出测试
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }

}
