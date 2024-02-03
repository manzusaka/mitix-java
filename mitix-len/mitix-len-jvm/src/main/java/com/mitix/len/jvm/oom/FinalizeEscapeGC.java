package com.mitix.len.jvm.oom;

/**
 * @author oldflame-jm
 * @create 2018/1/26
 * ${DESCRIPTION}
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes i am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize is excute");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次自救自己成功
        SAVE_HOOK = null;

        System.gc();
        //因为finalizef方法优先级低 所以暂停
        Thread.sleep(5000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no i am dead");
        }

        //第二次自救自己失败
        //对象第一次自救自己成功
        SAVE_HOOK = null;

        System.gc();
        //因为finalizef方法优先级低 所以暂停
        Thread.sleep(5000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no i am dead");
        }
        Thread.sleep(5000);
    }
}
