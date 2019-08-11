package com.mitix.len.jdk8base.jvm_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/9/2
 * ${DESCRIPTION}
 */
public class JvmTest {
    @Test
    /**
     * 测试运行时常量池溢出
     * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public void testRuntimeConstantPollOOM() {
        // 使用 List 保持着常量池引用，避免 Full GC 回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB 的 PermSize 在 integer 范围内足够产生 OOM 了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }


}
