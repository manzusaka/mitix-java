package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/2/3
 * 测试java虚拟机参数
 */
public class SimpleArgs {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数" + i + "的值为" + args[i]);
        }
        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory() / 1000 / 1000 + "M");
    }
}
