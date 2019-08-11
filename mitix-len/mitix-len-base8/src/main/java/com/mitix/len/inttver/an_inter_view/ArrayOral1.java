package com.mitix.len.inttver.an_inter_view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author oldflame-jm
 * @create 2018/4/29
 * 题目  有一个数组一个一个数字    使数组中一些值加起来可以等于那个数
 * 还没有完成
 */
public class ArrayOral1 {
    private List<Integer> list;
    private int num;

    public ArrayOral1(List list, int num) {
        this.list = list;
        this.num = num;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Integer num = new Random().nextInt(80);
            System.out.println("the index is " + i + " and the num is " + num);
            list.add(num);
        }
        Integer totalNum = 1234;
        ArrayOral1 arrayOral1 = new ArrayOral1(list, totalNum);
        arrayOral1.workOutChildArray();
    }

    private void workOutChildArray() {
        Collections.sort(list);
        Collections.reverse(list);
        doWorkOutChildArray(num, list, 0);
    }

    private void doWorkOutChildArray(int totalNum, List<Integer> list, int index) {
//        boolean maxBound = false;
//        int nowIndex = index;
//        List nowList = list;
//        int nowTotal = 0;
//        for (int i = nowIndex; i < nowList.size(); i++) {
//            nowTotal = nowTotal + (Integer) nowList.get(i);
//            if
//        }
    }
}
