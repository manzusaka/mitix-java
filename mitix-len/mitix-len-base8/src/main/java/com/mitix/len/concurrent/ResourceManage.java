package com.mitix.len.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class ResourceManage {
    private final Semaphore semaphore;
    private boolean[] resourceArray;
    private final ReentrantLock lock;

    public ResourceManage() {
        //存放厕所状态
        this.resourceArray = new boolean[10];
        //控制10个共享资源的使用，使用先进先出的公平模式进行共享;公平模式的信号量，先来的先获得信号量
        this.semaphore = new Semaphore(10, true);
        //公平模式的锁，先来的先选
        this.lock = new ReentrantLock(true);
        for (int i = 0; i < 10; i++) {
            //初始化为资源可用的情况
            resourceArray[i] = true;
        }
    }

    public void useResource(int userId) throws InterruptedException {
        semaphore.acquire();
        try {
            //semaphore.acquire();
            //占到一个坑
            int id = getResourceId();
            System.out.print("userId:" + userId + "正在使用资源，资源id:" + id + "\n");
            //do something，相当于于使用资源
            Thread.sleep(100);
            //退出这个坑
            resourceArray[id] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();//释放信号量，计数器加1
        }
    }

    private int getResourceId() {
        int id = -1;
        lock.lock();
        try {
            //lock.lock();//虽然使用了锁控制同步，但由于只是简单的一个数组遍历，效率还是很高的，所以基本不影响性能。
            for (int i = 0; i < 10; i++) {
                if (resourceArray[i]) {
                    resourceArray[i] = false;
                    id = i;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return id;
    }
}

class ResourceUser implements Runnable {
    private ResourceManage resourceManage;
    private int userId;

    public ResourceUser(ResourceManage resourceManage, int userId) {
        this.resourceManage = resourceManage;
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.print("userId:" + userId + "准备使用资源...\n");
        try {
            resourceManage.useResource(userId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("userId:" + userId + "使用资源完毕...\n");
    }

    public static void main(String[] args) {
        ResourceManage resourceManage = new ResourceManage();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            //创建多个资源使用者
            Thread thread = new Thread(new ResourceUser(resourceManage, i));
            threads[i] = thread;
        }
        for (int i = 0; i < 100; i++) {
            Thread thread = threads[i];
            try {
                thread.start();//启动线程
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

