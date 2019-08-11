package com.mitix.len.jdk8base;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author oldflame-jm
 * @create 2018/6/4
 * 状态位处理的一种方式
 * <p>
 * 位操作类
 */
public class BitOperationTest {
    public static final int OP_READ = 1 << 0;
    public static final int OP_WRITE = 1 << 2;
    public static final int OP_CONNECT = 1 << 3;

    public static void main(String[] args) {

        //说明 state 不是下面允许范围之内的状态位
        System.out.println(isInState(1 << 3));
        System.out.println(isInState(1 << 4));

        System.out.println("-----------------");
        //判断是否是2的指数次方
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));


    }

    /**
     * 一般定义状态位是正数时使用
     *
     * @param state 正数
     * @return
     */
    private static boolean isInState(int state) {
        return (state & ~optVs()) == 0;
    }

    /**
     * 判断是否是 2的整数倍的一种方式
     * <p>
     * 原理  2的指数次的负数  补码有变成了自己   然后&运算
     * <p>
     * 如果是+0当做2的0次方处理  返回还是true
     * <p>
     *
     * @param val 正数
     * @return
     */
    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }


    /**
     * 为或运算
     * <p>
     * 正数状态用，可以把状态为拼起来
     *
     * @return
     */
    private static int optVs() {
        return OP_READ | OP_WRITE | OP_CONNECT;
    }


    /**
     * netty中的两种数组循环
     */
    private static final class PowerOfTwoEventExecutorChooser implements EventExecutorChooser {
        private final AtomicInteger idx = new AtomicInteger();
        private final Executor[] executors;

        PowerOfTwoEventExecutorChooser(Executor[] executors) {
            this.executors = executors;
        }

        @Override
        public Executor next() {
            return executors[idx.getAndIncrement() & executors.length - 1];
        }
    }

    /**
     * netty中的两种数组循环
     */
    private static final class GenericEventExecutorChooser implements EventExecutorChooser {
        private final AtomicInteger idx = new AtomicInteger();
        private final Executor[] executors;

        GenericEventExecutorChooser(Executor[] executors) {
            this.executors = executors;
        }

        @Override
        public Executor next() {
            return executors[Math.abs(idx.getAndIncrement() % executors.length)];
        }
    }

    /**
     * 循环接口
     */
    interface EventExecutorChooser {
        Executor next();
    }

}
