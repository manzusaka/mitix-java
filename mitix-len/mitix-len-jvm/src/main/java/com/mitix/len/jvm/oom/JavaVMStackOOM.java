package com.mitix.len.jvm.oom;

/**
 * @author oldflame-jm
 * @since 1.0.0
 *
 * 代码高风险   会导致电脑假死
 * VM Args：-Xss2M
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {

        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }

    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
