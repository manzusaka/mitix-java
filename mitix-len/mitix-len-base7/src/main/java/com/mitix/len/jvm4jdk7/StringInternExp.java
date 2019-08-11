package com.mitix.len.jvm4jdk7;

/**
 * @author oldflame-jm
 * @create 2018/1/25
 * String类型从方法区迁移到了堆中  jdk7
 */
public class StringInternExp {

    public static void main(String[] args) {
        StringInternExp stringInternTest = new StringInternExp();
        stringInternTest.testOne();
        stringInternTest.testTwo();
    }

    public void testOne() {
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
    }

    public void testTwo() {
        String str2 = "SEUCalvin";//新加的一行代码，其余不变
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
    }
}
