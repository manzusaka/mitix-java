package com.mitix.len.multithread4oood.single_threaded_execution.exp3;


import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class ThreadSemaphoreTest {


    public static void main(String[] args) {

        ThreadSemaphore ts = new ThreadSemaphore();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Student(i + 1, ts));
            thread.start();
        }
    }

    static class Student implements Runnable {

        private int num;
        private ThreadSemaphore ts;

        public Student(int num, ThreadSemaphore ts) {
            this.num = num;
            this.ts = ts;
        }


        @Override
        public void run() {
            try {
                //获取跑道
                ThreadSemaphore.Track track = ts.getTrack();
                if (track != null) {
                    System.out.println("学生" + num + "在" + track.toString() + "上跑步");
                    TimeUnit.SECONDS.sleep(Math.round(5));
                    System.out.println("学生" + num + "释放" + track.toString());
                    //释放跑道
                    ts.releaseTrack(track);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
