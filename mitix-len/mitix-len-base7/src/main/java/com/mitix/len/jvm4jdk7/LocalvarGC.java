package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/2/3
 * 讨论局部变量表对于回收的意义
 */
public class LocalvarGC {
    private void localvarGC1() {
        byte[] b = new byte[6 * 1024 * 1024];
        System.gc();
    }

    private void localvarGC2() {
        byte[] b = new byte[6 * 1024 * 1024];
        b = null;
        System.gc();
    }

    private void localvarGC3() {
        {
            byte[] b = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    private void localvarGC4() {
        {

            byte[] b = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    private void localvarGC5() {
        localvarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalvarGC localvarGC = new LocalvarGC();
        localvarGC.localvarGC1();
        localvarGC.localvarGC2();
        localvarGC.localvarGC3();
        localvarGC.localvarGC4();
        localvarGC.localvarGC5();
    }
}
