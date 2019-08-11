package com.mitix.len.jdk7.exception;

/**
 * 链式异常代码测试
 * Created by oldflame on 2017/3/31.
 */
public class ExceptionExp {
    public static void main(String[] args) {
        Demo demo = new Demo();
        try {
            demo.getNumber();
        } catch (RuntimeException e) {
            RuntimeException ex = new RuntimeException();
            ex.initCause(e);
            throw ex;
        }
    }
}
