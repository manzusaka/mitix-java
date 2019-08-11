package com.mitix.len.multithread4oood.single_threaded_execution.exp1;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class SingleThreadedExecutionTest {
    public static void main(String[] args) {
        Gate gate = new Gate();
        UserThread userThread1 = new UserThread(gate, "Ada", "Alaba");
        UserThread userThread2 = new UserThread(gate, "Blili", "Bnama");
        UserThread userThread3 = new UserThread(gate, "Cana", "Chinese");
        UserThread userThread4 = new UserThread(gate, "Dulada", "Dgelasi");

        Thread thread1 = new Thread(userThread1);
        thread1.start();
        Thread thread2 = new Thread(userThread2);
        thread2.start();
        Thread thread3 = new Thread(userThread3);
        thread3.start();
        Thread thread4 = new Thread(userThread4);
        thread4.start();

    }
}
