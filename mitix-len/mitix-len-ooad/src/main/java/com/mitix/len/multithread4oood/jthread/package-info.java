/**
 * @author oldflame-jm
 * @create 2018/3/5
 * 讲解最基础的线程信息
 */
package com.mitix.len.multithread4oood.jthread;
//单线程程序就是代码从开始执行，无论怎么执行都是线性的

//启动线程方法：
// 1  MyThread  线程新建  Thread的run和start
// 2  PrintThread 利用Thread子类
// 3  PrintRunnable  利用Runnable接口
// 4  PrintThreadFactory  利用ThreadFactory
// 5  ThreadSleepTest  线程暂停
// 6  线程的互斥   synchronized  lock
// 7  DaemonThreadTest守护线程测试
// 备注：  线程的互斥机制称为监视 monitor  获取锁有时候也叫  拥有（own）监视或者持有（hold）锁
// 8. ThreadCooperationTest 线程的协作 wait()  notify()  notifyAll()
// 9. TreadWaitTest测试wait动作
// 10. ThreadInterruptTest测试线程的中断