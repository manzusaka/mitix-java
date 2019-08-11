package com.mitix.len.jdk8base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author oldflame-jm
 * @create 2018/4/30
 * ${DESCRIPTION}
 */
public class ArrayListExp {

    /**
     * 测试当数组比list短的时候的拷贝
     * 说明当list > 数组长度时  数组会加长
     */
    @Test
    public void testToArray() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        String[] arr = new String[2];
        arr = list.toArray(arr);
        System.out.println(arr.length);
    }

    /**
     * 测试add方法时候会改变默认的size
     */
    @Test
    public void testAddChangeSize() {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("size is " + list.size());
        list.add("aa");
        System.out.println("size after add is " + list.size());
        list.add("bb");
        System.out.println("size after add2 is " + list.size());
        list.trimToSize();
        System.out.println("size after trim is " + list.size());
    }

    /**
     * ArrayList不通的迭代方式   访问效率测试
     * 三种方式的效率基本一致
     */
    @Test
    public void testThru() {
        List list = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        isRandomAccessSupported(list);
        iteratorThroughRandomAccess(list);
        iteratorThroughIterator(list);
        iteratorThroughFor2(list);
    }

    /**
     * 重要api操作
     */
    @Test
    public void testApis() {
        // 创建ArrayList
        ArrayList list = new ArrayList();

        // 将“”
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        // 将下面的元素添加到第1个位置
        list.add(0, "5");

        // 获取第1个元素
        System.out.println("the first element is: " + list.get(0));
        // 删除“3”
        list.remove("3");
        // 获取ArrayList的大小
        System.out.println("Arraylist size=: " + list.size());
        // 判断list中是否包含"3"
        System.out.println("ArrayList contains 3 is: " + list.contains(3));
        // 设置第2个元素为10
        list.set(1, "10");

        // 通过Iterator遍历ArrayList
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            System.out.println("next is: " + iter.next());
        }

        // 将ArrayList转换为数组
        String[] arr = (String[]) list.toArray(new String[0]);
        for (String str : arr) {
            System.out.println("str: " + str);
        }

        // 清空ArrayList
        list.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: " + list.isEmpty());
    }

    /**
     * 测试indexof  进行切分
     */
    @Test
    public void testIndexof() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        Collections.sort(list);
        System.out.println(list);
        int index;
        for (index = list.size() - 1; index >= 0; index--) {
            if (list.get(index) <= 10) {
                break;
            }
        }
        Integer[] low = new Integer[0];
        Integer[] up = new Integer[0];
        System.out.println(index);
        low = list.subList(0, index + 1).toArray(low);
        up = list.subList(index + 1, list.size() - 1).toArray(up);

    }


    /**
     * 设置排序查找方法
     */
    @Test
    public void binarySearchTest() {
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("林青霞", 27));
        list2.add(new Student("风清扬", 30));
        list2.add(new Student("刘晓曲", 28));
        list2.add(new Student("武鑫", 29));
        list2.add(new Student("林青霞", 27));

        int index1 = Collections.binarySearch(list2, new Student("林青霞", 28),
                new MyComparator());
        System.out.println(index1);
    }

    class MyComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getAge() - s2.getAge();
        }
    }

    class Student {
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    /**
     * 查看list有没有实现随机访问接口RandomAccess
     */
    private void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    /**
     * 使用了随机访问的方式迭代
     *
     * @param list
     */
    public void iteratorThroughRandomAccess(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        //RandomAccess接口的随机访问
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval + " ms");
    }

    /**
     * 使用迭代器进行访问
     *
     * @param list
     */
    public void iteratorThroughIterator(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        //使用Iterator迭代器的方式
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval + " ms");
    }

    /**
     * 使用for循环list的方式
     *
     * @param list
     */
    public void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        //直接使用for循环
        for (Object obj : list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval + " ms");
    }


}
