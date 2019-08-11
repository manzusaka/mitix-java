package com.mitix.len.jdk8base.concurrent.book2.exp5;

/**
 * @author oldflame-jm
 * @create 2018/7/12
 * ${DESCRIPTION}
 */
public class ConditionUseCaseTest {
    public static void main(String[] args) {
        ConditionUseCase conditionUseCase = new ConditionUseCase();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionUseCase.conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
