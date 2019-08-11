package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/1/25
 * java方法栈溢出
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable t) {
            System.out.println("stackLength=" + javaVMStackSOF.stackLength);
            t.printStackTrace();
        }
    }
}
