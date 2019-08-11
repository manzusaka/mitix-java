package com.mitix.len.jdk8base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @author oldflame-jm
 * @create 2018/4/30
 * ${DESCRIPTION}
 */
public class ListCompareTest {
    private int COUNT = 1000000;

    /**
     * 比较特长
     */
    @Test
    public void testpeciality() {

        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        Vector vector = new Vector();
        Stack stack = new Stack();

        // 换行符
        System.out.println();
        // 插入
        insertByPosition(stack);
        insertByPosition(vector);
        insertByPosition(linkedList);
        insertByPosition(arrayList);

        // 换行符
        System.out.println();
        // 随机读取
        readByPosition(stack);
        readByPosition(vector);
        readByPosition(linkedList);
        readByPosition(arrayList);

        // 换行符
        System.out.println();
        // 删除
        deleteByPosition(stack);
        deleteByPosition(vector);
        deleteByPosition(linkedList);
        deleteByPosition(arrayList);
    }

    /**
     * 获取list的名称
     */
    private String getListName(List list) {
        if (list instanceof LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Stack) {
            return "Stack";
        } else if (list instanceof Vector) {
            return "Vector";
        } else {
            return "List";
        }
    }

    /**
     * 向list的指定位置插入COUNT个元素，并统计时间
     *
     * @param list
     */
    private void insertByPosition(List list) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0插入COUNT个数
        for (int i = 0; i < COUNT; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : insert " + COUNT + " elements into the 1st position use time：" + interval + " ms");
    }

    /**
     * 从list的指定位置删除COUNT个元素，并统计时间
     *
     * @param list
     */
    private void deleteByPosition(List list) {
        long startTime = System.currentTimeMillis();
        // 删除list第一个位置元素
        for (int i = 0; i < COUNT; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : delete " + COUNT + " elements from the 1st position use time：" + interval + " ms");
    }

    /**
     * 根据position，不断从list中读取元素，并统计时间
     *
     * @param list
     */
    private void readByPosition(List list) {
        long startTime = System.currentTimeMillis();

        // 读取list元素
        for (int i = 0; i < COUNT; i++) {
            list.get(i);
        }

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : read " + COUNT + " elements by position use time：" + interval + " ms");
    }
}
