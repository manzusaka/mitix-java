package com.mitix.len.jvm.oom;

/**
 * @author oldflame-jm
 * @create 2018/1/25
 * java方法栈溢出
 *
 * VM Args：-Xss128k
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
