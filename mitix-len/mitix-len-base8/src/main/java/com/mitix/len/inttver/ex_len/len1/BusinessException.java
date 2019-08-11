package com.mitix.len.inttver.ex_len.len1;

/**
 * @author oldflame-jm
 * @create 2018/5/16
 * ${DESCRIPTION}
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

//    @Override
//    public Throwable fillInStackTrace() {
//        return this;
//    }
}
