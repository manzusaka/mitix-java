package com.mitix.len.jvm.allocmemory;

/**
 * @author oldflame-jm
 * @since 1.0.0
 * 大对象直接进入老年代测试
 * 该测试在UseParNewGC下生效
 * -verbose:gc -XX:+UseParNewGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 **/

public class PretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        //直接分配在老年代中
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
