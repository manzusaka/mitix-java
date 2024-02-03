package com.mitix.len.jvm.booleanalgebra;

/**
 * @author oldflame-jm
 * @since 1.0.0
 * //测试jvm线程栈帧的深度
 */
public class JvmStackOverflow {

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        JvmStackOverflow jsof = new JvmStackOverflow();
        try {
            jsof.stackLeak();
        } catch (Throwable e) {
            System.out.println("当前栈深度:stackLength=" + jsof.stackLength);
            e.printStackTrace();
        }
    }
}
