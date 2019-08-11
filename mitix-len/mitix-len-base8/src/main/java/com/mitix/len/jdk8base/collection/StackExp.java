package com.mitix.len.jdk8base.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author oldflame-jm
 * @create 2018/4/30
 * ${DESCRIPTION}
 */
public class StackExp {

    /**
     * 栈相关的api操作
     */
    @Test
    public void testApis() {
        Stack stack = new Stack();
        // 将1,2,3,4,5添加到栈中
        for (int i = 1; i < 6; i++) {
            stack.push(String.valueOf(i));
        }

        // 遍历并打印出该栈
        iteratorThroughRandomAccess(stack);

        // 查找“2”在栈中的位置，并输出
        int pos = stack.search("2");
        System.out.println("the postion of 2 is:" + pos);

        // pup栈顶元素之后，遍历栈
        stack.pop();
        iteratorThroughRandomAccess(stack);

        // peek栈顶元素之后，遍历栈
        String val = (String) stack.peek();
        System.out.println("peek:" + val);
        iteratorThroughRandomAccess(stack);

        // 通过Iterator去遍历Stack
        iteratorThroughIterator(stack);
    }

    /**
     * 通过快速访问遍历Stack
     */
    public void iteratorThroughRandomAccess(List list) {
        String val = null;
        for (int i = 0; i < list.size(); i++) {
            val = (String) list.get(i);
            System.out.print(val + " ");
        }
        System.out.println();
    }

    /**
     * 通过迭代器遍历Stack
     */
    public void iteratorThroughIterator(List list) {

        String val = null;
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            val = (String) iter.next();
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
