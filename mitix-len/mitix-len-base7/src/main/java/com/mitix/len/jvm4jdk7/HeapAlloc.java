package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/2/4
 * 测试 -Xms   -Xmx
 */
public class HeapAlloc {
    public static void main(String[] args) {
        System.out.println("maxMemory1=" + (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + "M");
        System.out.println("freeMemory1=" + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + "M");
        System.out.println("totalMemory1=" + (Runtime.getRuntime().totalMemory() / (1024 * 1024)) + "M");

        byte[] b = new byte[1 * 1024 * 1024];
        System.out.println("--------系统分配1M的空间给了数组");
        System.out.println("maxMemory1=" + (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + "M");
        System.out.println("freeMemory1=" + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + "M");
        System.out.println("totalMemory1=" + (Runtime.getRuntime().totalMemory() / (1024 * 1024)) + "M");


        byte[] b1 = new byte[4 * 1024 * 1024];
        System.out.println("---------系统分配4M的空间给了数组");
        System.out.println("maxMemory1=" + (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + "M");
        System.out.println("freeMemory1=" + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + "M");
        System.out.println("totalMemory1=" + (Runtime.getRuntime().totalMemory() / (1024 * 1024)) + "M");
    }
}
