package com.mitix.len.jvm4jdk7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/1/25
 * 常量池溢出
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
