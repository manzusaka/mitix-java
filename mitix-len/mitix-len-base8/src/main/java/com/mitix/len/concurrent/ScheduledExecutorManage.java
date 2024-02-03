package com.mitix.len.concurrent;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class ScheduledExecutorManage {
    public static void main(String[] args) {
        ScheduledExecutorManage manage = new ScheduledExecutorManage();
        //manage.testSchedule();
        manage.testScheduleAtFixedRate();
    }

    private void testSchedule() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        System.out.println("start schedule at " + new Date());
        //延时3秒执行
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduled at " + new Date());
            }
        }, 3, TimeUnit.SECONDS);
    }

    private void testScheduleAtFixedRate() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        System.out.println("start schedule FixedRate at " + new Date());
        //延时3秒执行
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduled FixedRate at " + new Date());
                try {
                    Thread.sleep(new Random().nextInt(10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3, 3, TimeUnit.SECONDS);
    }
}
