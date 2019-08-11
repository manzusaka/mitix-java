package com.mitix.len.jdk8base.collection;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Vector;

/**
 * @author oldflame-jm
 * @create 2018/4/30
 * ${DESCRIPTION}
 */
public class VectorTest {

    /**
     * 测试访问效率
     */
    @Test
    public void testThru() {
        Vector vec = new Vector();
        for (int i = 0; i < 1000000; i++) {
            vec.add(i);
        }
        iteratorThroughRandomAccess(vec);
        iteratorThroughIterator(vec);
        iteratorThroughFor2(vec);
        iteratorThroughEnumeration(vec);
    }

    /**
     * 测试api
     */
    @Test
    public void testApis() {
        // 新建Vector
        Vector vec = new Vector();

        // 添加元素
        vec.add("1");
        vec.add("2");
        vec.add("3");
        vec.add("4");
        vec.add("5");

        // 设置第一个元素为100
        vec.set(0, "100");
        // 将“500”插入到第3个位置
        vec.add(2, "300");
        System.out.println("vec:" + vec);

        // (顺序查找)获取100的索引
        System.out.println("vec.indexOf(100):" + vec.indexOf("100"));
        // (倒序查找)获取100的索引
        System.out.println("vec.lastIndexOf(100):" + vec.lastIndexOf("100"));
        // 获取第一个元素
        System.out.println("vec.firstElement():" + vec.firstElement());
        // 获取第3个元素
        System.out.println("vec.elementAt(2):" + vec.elementAt(2));
        // 获取最后一个元素
        System.out.println("vec.lastElement():" + vec.lastElement());

        // 获取Vector的大小
        System.out.println("size:" + vec.size());
        // 获取Vector的总的容量
        System.out.println("capacity:" + vec.capacity());

        // 获取vector的“第2”到“第4”个元素
        System.out.println("vec 2 to 4:" + vec.subList(1, 4));

        // 通过Enumeration遍历Vector
        Enumeration enu = vec.elements();
        while (enu.hasMoreElements())
            System.out.println("nextElement():" + enu.nextElement());

        Vector retainVec = new Vector();
        retainVec.add("100");
        retainVec.add("300");
        // 获取“vec”中包含在“retainVec中的元素”的集合
        System.out.println("vec.retain():" + vec.retainAll(retainVec));
        System.out.println("vec:" + vec);

        // 获取vec对应的String数组
        String[] arr = (String[]) vec.toArray(new String[0]);
        for (String str : arr)
            System.out.println("str:" + str);

        // 清空Vector。clear()和removeAllElements()一样！
        vec.clear();
        //vec.removeAllElements();

        // 判断Vector是否为空
        System.out.println("vec.isEmpty():" + vec.isEmpty());
    }

    private void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    /**
     * 随机访问的方式
     *
     * @param list
     */
    public void iteratorThroughRandomAccess(List list) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval + " ms");
    }

    /**
     * 迭代器方式
     *
     * @param list
     */
    public void iteratorThroughIterator(List list) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval + " ms");
    }

    /**
     * 直接使用for循环
     *
     * @param list
     */
    public void iteratorThroughFor2(List list) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (Object obj : list) {
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval + " ms");
    }

    /**
     * 使用Enumeration遍历
     *
     * @param vec
     */
    public void iteratorThroughEnumeration(Vector vec) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (Enumeration enu = vec.elements(); enu.hasMoreElements(); ) {
            enu.nextElement();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughEnumeration：" + interval + " ms");
    }
}
