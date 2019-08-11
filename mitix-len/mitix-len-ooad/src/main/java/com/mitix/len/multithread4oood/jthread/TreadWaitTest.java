package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class TreadWaitTest {

    public static void main(String[] args) {
        try {
            WaitExp1 exp1 = new WaitExp1();
            System.out.println(exp1.pleaseWait());
            System.out.println(exp1.pleaseWait());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            WaitExp2 exp2 = new WaitExp2();
            System.out.println(exp2.pleaseWait());
            System.out.println(exp2.pleaseWait());
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    static class WaitExp1 {
        private Boolean wait = false;

        public boolean pleaseWait() {
            synchronized (this.wait) {
                if (this.wait == true) {
                    return false;
                }
                this.wait = true;
                try {
                    this.wait.wait();
                } catch (InterruptedException e) {

                }
                return true;
            }
        }
    }

    static class WaitExp2 {
        private AtomicBoolean wait = new AtomicBoolean(false);

        public boolean pleaseWait() {
            synchronized (this.wait) {
                if (this.wait.get() == true) {
                    return false;
                }

                this.wait.set(true);

                try {
                    this.wait.wait();
                } catch (InterruptedException e) {

                }

                return true;
            }
        }
    }

}

