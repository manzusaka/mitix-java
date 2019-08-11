package com.mitix.len.jdk8base.concurrent.book2.exp2;

/**
 * @author oldflame-jm
 * @create 2018/5/10
 * ${DESCRIPTION}
 */
public class ReorderExample {

    int a = 0;
    boolean flag = false;

    public void writer() {
        // 1
        a = 1;
        // 2
        flag = true;
    }

    public void reader() {
        // 3
        if (flag) {
            // 4
            System.out.println(a * a);
        }
    }


    public static void main(String[] args) {
        for (; ; ) {
            ReorderExample reorderExample = new ReorderExample();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    reorderExample.writer();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    reorderExample.reader();
                }
            });

            t1.run();
            t2.run();

        }
    }


}
