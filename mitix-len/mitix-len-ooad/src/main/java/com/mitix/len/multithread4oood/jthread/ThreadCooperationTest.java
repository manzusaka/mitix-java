package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class ThreadCooperationTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadCop1());
        Thread t2 = new Thread(new ThreadCop2());
        t1.start();
        t2.start();
    }

    static class ThreadCop1 implements Runnable {
        @Override
        public void run() {
            ThreadCooperation cooperation = new ThreadCooperation();
            cooperation.doSamething();
        }
    }

    static class ThreadCop2 implements Runnable {
        @Override
        public void run() {
            ThreadCooperation cooperation = new ThreadCooperation();
            cooperation.doSamething2();
        }
    }
}

