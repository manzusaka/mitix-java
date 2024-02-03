package com.mitix.len.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/1/25
 * 常量池溢出
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
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
