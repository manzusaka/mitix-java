package com.mitix.len.multithread4oood.balking;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class ChangedThread extends Thread {
    private final MitixData data;
    private int count = 0;

    public ChangedThread(String name, MitixData data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                count++;
                //改变文件
                data.change("No." + count);
                TimeUnit.MILLISECONDS.sleep(1000);
                //显示的做了保存
                data.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
