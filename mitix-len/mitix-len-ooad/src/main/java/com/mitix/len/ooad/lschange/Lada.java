package com.mitix.len.ooad.lschange;

/**
 * @author oldflame-jm
 * @create 2018/4/5
 * ${DESCRIPTION}
 */
public class Lada extends Student {
    //这个时候必须是public方法   不然是编译不过的
    @Override
    public void sayName(String name) {
        System.out.println("my name is lada" + name);
    }
}
