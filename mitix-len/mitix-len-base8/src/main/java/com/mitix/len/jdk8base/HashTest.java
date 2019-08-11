package com.mitix.len.jdk8base;

/**
 * @author oldflame-jm
 * @create 2018/3/2
 * ${DESCRIPTION}
 */
public class HashTest {
    public static void main(String[] args) {
        String aa = "aaa";
        String bb = "aaa";
        String cc = new String("aaa");
        String dd = new String("aaa");
        StringBuffer stringBuffer = new StringBuffer();
        String ee = stringBuffer.append("a").append("aa").toString();
        System.out.println("aa hash is " + aa.hashCode());
        System.out.println("bb hash is " + bb.hashCode());
        System.out.println("cc hash is " + cc.hashCode());
        System.out.println("dd hash is " + dd.hashCode());
        System.out.println("bf hash is " + stringBuffer.toString().hashCode());
        System.out.println("dd hash is " + ee.hashCode());
        Object o = new Object();

    }
}
