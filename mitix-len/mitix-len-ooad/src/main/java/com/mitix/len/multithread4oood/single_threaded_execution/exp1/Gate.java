package com.mitix.len.multithread4oood.single_threaded_execution.exp1;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class Gate {
    private int counter = 0;
    private String name = "";
    private String address = "";

    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
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
