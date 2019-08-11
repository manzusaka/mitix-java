package com.mitix.len.multithread4oood.single_threaded_execution.exp1;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class UserThread implements Runnable {
    private final Gate gate;
    private final String name;
    private final String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println("my name is " + this.name + " and  address is " + this.address);
        while (true) {
            gate.pass(this.name, this.address);
        }
    }
}
