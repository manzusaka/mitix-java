package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/1/26
 * ${DESCRIPTION}
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int M_1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * M_1MB];

    public static void testGC() {
        ReferenceCountingGC object1 = new ReferenceCountingGC();
        ReferenceCountingGC object2 = new ReferenceCountingGC();
        object1.instance = object2;
        object2.instance = object1;

        object1 = null;
        object2 = null;
        System.gc();

    }


    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
