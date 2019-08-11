package com.mitix.len.jdk8base.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author oldflame-jm
 * @create 2018/4/30
 * ${DESCRIPTION}
 */
public class LinkedListExp {
    /**
     * 测试随机迭代的效率
     * 测试结果  LinkedList不要使用随机访问  因为没有实现随机访问接口  所以会很慢
     */
    @Test
    public void testThru() {
        // 通过Iterator遍历LinkedList
        iteratorLinkedListThruIterator(getLinkedList());

        // 通过快速随机访问遍历LinkedList
        iteratorLinkedListThruForeach(getLinkedList());

        // 通过for循环的变种来访问遍历LinkedList
        iteratorThroughFor2(getLinkedList());

        // 通过PollFirst()遍历LinkedList
        iteratorThroughPollFirst(getLinkedList());

        // 通过PollLast()遍历LinkedList
        iteratorThroughPollLast(getLinkedList());

        // 通过removeFirst()遍历LinkedList
        iteratorThroughRemoveFirst(getLinkedList());

        // 通过removeLast()遍历LinkedList
        iteratorThroughRemoveLast(getLinkedList());
    }

    /**
     * 测试LinkedLIst的api
     * 把LinkedList当做  list  (LIFO堆栈  FIFO队列)
     */
    @Test
    public void testApis() {
        // 测试LinkedList的API
        testLinkedListAPIs();

        // 将LinkedList当作 LIFO(后进先出)的堆栈
        useLinkedListAsLIFO();

        // 将LinkedList当作 FIFO(先进先出)的队列
        useLinkedListAsFIFO();
    }


    /**
     * 测试LinkedList中部分API
     */
    private void testLinkedListAPIs() {
        String val = null;
        //LinkedList llist;
        //llist.offer("10");
        // 新建一个LinkedList
        LinkedList llist = new LinkedList();
        //---- 添加操作 ----
        // 依次添加1,2,3
        llist.add("1");
        llist.add("2");
        llist.add("3");

        // 将“4”添加到第一个位置
        llist.add(1, "4");


        System.out.println("\nTest \"addFirst(), removeFirst(), getFirst()\"");
        // (01) 将“10”添加到第一个位置。  失败的话，抛出异常！
        llist.addFirst("10");
        System.out.println("llist:" + llist);
        // (02) 将第一个元素删除。        失败的话，抛出异常！
        System.out.println("llist.removeFirst():" + llist.removeFirst());
        System.out.println("llist:" + llist);
        // (03) 获取第一个元素。          失败的话，抛出异常！
        System.out.println("llist.getFirst():" + llist.getFirst());


        System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");
        // (01) 将“10”添加到第一个位置。  返回true。
        llist.offerFirst("10");
        System.out.println("llist:" + llist);
        // (02) 将第一个元素删除。        失败的话，返回null。
        System.out.println("llist.pollFirst():" + llist.pollFirst());
        System.out.println("llist:" + llist);
        // (03) 获取第一个元素。          失败的话，返回null。
        System.out.println("llist.peekFirst():" + llist.peekFirst());


        System.out.println("\nTest \"addLast(), removeLast(), getLast()\"");
        // (01) 将“20”添加到最后一个位置。  失败的话，抛出异常！
        llist.addLast("20");
        System.out.println("llist:" + llist);
        // (02) 将最后一个元素删除。        失败的话，抛出异常！
        System.out.println("llist.removeLast():" + llist.removeLast());
        System.out.println("llist:" + llist);
        // (03) 获取最后一个元素。          失败的话，抛出异常！
        System.out.println("llist.getLast():" + llist.getLast());


        System.out.println("\nTest \"offerLast(), pollLast(), peekLast()\"");
        // (01) 将“20”添加到第一个位置。  返回true。
        llist.offerLast("20");
        System.out.println("llist:" + llist);
        // (02) 将第一个元素删除。        失败的话，返回null。
        System.out.println("llist.pollLast():" + llist.pollLast());
        System.out.println("llist:" + llist);
        // (03) 获取第一个元素。          失败的话，返回null。
        System.out.println("llist.peekLast():" + llist.peekLast());


        // 将第3个元素设置300。不建议在LinkedList中使用此操作，因为效率低！
        llist.set(2, "300");
        // 获取第3个元素。不建议在LinkedList中使用此操作，因为效率低！
        System.out.println("\nget(3):" + llist.get(2));


        // ---- toArray(T[] a) ----
        // 将LinkedList转行为数组
        String[] arr = (String[]) llist.toArray(new String[0]);
        for (String str : arr)
            System.out.println("str:" + str);

        // 输出大小
        System.out.println("size:" + llist.size());
        // 清空LinkedList
        llist.clear();
        // 判断LinkedList是否为空
        System.out.println("isEmpty():" + llist.isEmpty() + "\n");

    }

    /**
     * 将LinkedList当作 LIFO(后进先出)的堆栈
     */
    private void useLinkedListAsLIFO() {
        System.out.println("\nuseLinkedListAsLIFO");
        // 新建一个LinkedList
        LinkedList stack = new LinkedList();

        // 将1,2,3,4添加到堆栈中
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        // 打印“栈”
        System.out.println("stack:" + stack);

        // 删除“栈顶元素”
        System.out.println("stack.pop():" + stack.pop());

        // 取出“栈顶元素”
        System.out.println("stack.peek():" + stack.peek());

        // 打印“栈”
        System.out.println("stack:" + stack);
    }

    /**
     * 将LinkedList当作 FIFO(先进先出)的队列
     */
    private void useLinkedListAsFIFO() {
        System.out.println("\nuseLinkedListAsFIFO");
        // 新建一个LinkedList
        LinkedList queue = new LinkedList();

        // 将10,20,30,40添加到队列。每次都是插入到末尾
        queue.add("10");
        queue.add("20");
        queue.add("30");
        queue.add("40");
        // 打印“队列”
        System.out.println("queue:" + queue);

        // 删除(队列的第一个元素)
        System.out.println("queue.remove():" + queue.remove());

        // 读取(队列的第一个元素)
        System.out.println("queue.element():" + queue.element());

        // 打印“队列”
        System.out.println("queue:" + queue);
    }


    private LinkedList getLinkedList() {
        LinkedList llist = new LinkedList();
        for (int i = 0; i < 100000; i++) {
            llist.addLast(i);
        }

        return llist;
    }

    /**
     * 43      * 通过快迭代器遍历LinkedList
     * 44
     */
    private void iteratorLinkedListThruIterator(LinkedList<Integer> list) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorLinkedListThruIterator：" + interval + " ms");
    }

    /**
     * 通过快速随机访问遍历LinkedList
     */
    private void iteratorLinkedListThruForeach(LinkedList<Integer> list) {
        // 记录开始时间
        long start = System.currentTimeMillis();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorLinkedListThruForeach：" + interval + " ms");
    }

    /**
     * 通过另外一种for循环来遍历LinkedList
     */
    private void iteratorThroughFor2(LinkedList<Integer> list) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        for (Integer integ : list) {

        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughFor2：" + interval + " ms");
    }

    /**
     * 通过pollFirst()来遍历LinkedList
     */
    private void iteratorThroughPollFirst(LinkedList<Integer> list) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        while (list.pollFirst() != null) {
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughPollFirst：" + interval + " ms");

    }

    /**
     * 通过pollLast()来遍历LinkedList
     */
    private void iteratorThroughPollLast(LinkedList<Integer> list) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        while (list.pollLast() != null) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughPollLast：" + interval + " ms");

    }

    /**
     * 通过removeFirst()来遍历LinkedList
     */


    private void iteratorThroughRemoveFirst(LinkedList<Integer> list) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while (list.removeFirst() != null) {
            }

        } catch (NoSuchElementException e) {

        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughRemoveFirst：" + interval + " ms");

    }

    /**
     * 通过removeLast()来遍历LinkedList
     */
    private void iteratorThroughRemoveLast(LinkedList<Integer> list) {

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while (list.removeLast() != null) {
            }

        } catch (NoSuchElementException e) {

        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughRemoveLast：" + interval + " ms");

    }


}
