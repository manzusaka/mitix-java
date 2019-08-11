package com.mitix.len.multithread4oood.single_threaded_execution.exp2;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class Gate {
    private final Object doorlock = new Object();
    private int counter = 0;
    private String name = "";
    private String address = "";

    public void pass(String name, String address) {
        //这里相当于用synchronized 关键字处理了门同时通过的可能性
        //相当于一定要一个人通过，按下按钮说我已经完全通过了   第二个才可以进去
        synchronized (doorlock) {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        }
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("this is broken  " + toString());
        }
    }

    @Override
    public String toString() {
        return "this No is [" + this.counter + "] name is [" + this.name + "] address is [" + this.address + "]";
    }
}
