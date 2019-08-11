package com.mitix.len.multithread4oood.balking;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class MitixData {
    private final String fileName;
    private String content;
    private boolean changed = false;

    public MitixData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    //修改数据
    public synchronized void change(String newContent) {
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() {
        if (!changed) {
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName() + "save content {" + this.content + "}");
    }
}
