package com.mitix.len.jdk8base.concurrent.book1.exp1;

public class PriorityExp {
    //线程优先级
    public static class HightPriority extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityExp.class) {
                    count++;
                    if (count > 10000000) {
                        System.out.println("this is higth Priority complete");
                        break;
                    }
                }
            }

        }

    }

    public static class LowPriority extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityExp.class) {
                    count++;
                    if (count > 10000000) {
                        System.out.println("this is low Priority complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HightPriority hightPriority = new HightPriority();
        LowPriority lowPriority = new LowPriority();
        //这里不是局对的 肯能还要看CPU的中断速度
        hightPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        lowPriority.start();
        hightPriority.start();
    }
}
