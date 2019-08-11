package com.mitix.len.jdk8base.concurrent.book2.exp4.e4;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author oldflame-jm
 * @create 2018/6/30
 * ${DESCRIPTION}
 */
public class ConnectionPool {
    //使用队列的方式更加明显
    private Queue<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                //创建了一个链接代理   没有创建真实的链接
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            //同步调度锁定线程池  归还链接
            synchronized (pool) {
                // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.add(connection);
                pool.notifyAll();
            }
        }
    }

    // 在mills内无法获取到连接，将会返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        //同步调度
        synchronized (pool) {

            if (mills <= 0) {
                //死等方式
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.remove();
            } else {
                //1000ms
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                //如果队列缺链接以及 等待时间还是>0的  那就继续等待
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    //剩余等待时间
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.remove();
                }
                return result;
            }
        }
    }
}
