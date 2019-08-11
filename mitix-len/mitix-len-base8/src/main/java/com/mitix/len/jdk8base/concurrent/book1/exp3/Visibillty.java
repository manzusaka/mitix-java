package com.mitix.len.jdk8base.concurrent.book1.exp3;

public class Visibillty extends Thread {

    private boolean stop;

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("finish looop  i is =" + i);
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean getStop() {
        return stop;
    }


    public static void main(String[] args) {
        Visibillty visibillty = new Visibillty();
        visibillty.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        visibillty.setStop(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main finish");
        System.out.println("stop is " + visibillty.getStop());
    }
}

