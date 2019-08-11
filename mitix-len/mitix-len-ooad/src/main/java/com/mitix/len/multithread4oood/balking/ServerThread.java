package com.mitix.len.multithread4oood.balking;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class ServerThread extends Thread {
    private final MitixData data;

    public ServerThread(String name, MitixData data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                data.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
