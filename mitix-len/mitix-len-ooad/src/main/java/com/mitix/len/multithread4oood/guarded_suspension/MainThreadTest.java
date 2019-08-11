package com.mitix.len.multithread4oood.guarded_suspension;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class MainThreadTest {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ServerThread(queue, "server1").start();
        new ServerThread(queue, "server2").start();
        new ServerThread(queue, "server3").start();
        new ServerThread(queue, "server4").start();
        new ServerThread(queue, "server5").start();
        new ClientThread(queue, "client").start();
    }
}
