package com.mitix.len.jdk8base;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class ForTest {
    public static void main(String[] args) {
        int count = 10;

        for (int i = 0; i < count; ++i) {
            System.out.printf("this ++i to i is %d\n", i);
        }

        for (int i = 0; i < count; i++) {
            System.out.printf("this i++ to i is %d\n", i);
        }


        double last = 253;
        double firet = 249;
        System.out.println(last - firet);
    }
}
