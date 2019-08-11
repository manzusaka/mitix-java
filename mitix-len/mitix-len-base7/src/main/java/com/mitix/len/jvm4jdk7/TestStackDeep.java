package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/2/3
 * 测试方法栈的深度
 */
public class TestStackDeep {
    private static int count = 0;

    private static void reCuration(int a, int b, int c) {
        long x = 1, y = 1, z = 1;
        String aa = "aa", bb = "bb";
        System.out.println(x + y + z);
        System.out.println(aa + bb);
        count++;
        reCuration(a, b, c);
    }


    public static void main(String[] args) {
        try {
            int x = 1, y = 2, z = 3;

            reCuration(x, y, z);

        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("this max stack deep is " + count);
        }
    }
}
