package com.mitix.len.jdk8base;

/**
 * @author oldflame-jm
 * @create 2018/10
 * @see
 * @since
 */
public class IdWorker {
//    //开始该类生成ID的时间截 占 0-41 位（还有一位是符号位，永远为 0）
//    private final long startTime = 1463834116272L;
//
//    //机器id所占的位数
//    private long workerIdBits = 5L;
//
//    //数据标识id所占的位数
//    private long datacenterIdBits = 5L;
//
//    //支持的最大机器id，结果是31,这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数
//    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
//
//    //支持的最大数据标识id
//    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
//
//    //序列在id中占的位数
//    private long sequenceBits = 12L;
//
//    //机器id向左移12位
//    private long workerIdLeftShift = sequenceBits;
//
//    //数据标识id向左移17位
//    private long datacenterIdLeftShift = workerIdBits + workerIdLeftShift;
//
//    //时间截向左移5+5+12=22位
//    private long timestampLeftShift = datacenterIdBits + datacenterIdLeftShift;
//
//    //生成序列的掩码，这里为1111 1111 1111
//    private long sequenceMask = -1 ^ (-1 << sequenceBits);
//
//    private long workerId;
//
//    private long datacenterId;
//
//    //同一个时间截内生成的序列数，初始值是0，从0开始
//    private long sequence = 0L;
//
//    //上次生成id的时间截
//    private long lastTimestamp = -1L;
//
//    public IdWorker(long workerId, long datacenterId) {
//        if (workerId < 0 || workerId > maxWorkerId) {
//            throw new IllegalArgumentException(
//                    String.format("workerId[%d] is less than 0 or greater than maxWorkerId[%d].", workerId, maxWorkerId));
//        }
//        if (datacenterId < 0 || datacenterId > maxDatacenterId) {
//            throw new IllegalArgumentException(
//                    String.format("datacenterId[%d] is less than 0 or greater than maxDatacenterId[%d].", datacenterId, maxDatacenterId));
//        }
//        this.workerId = workerId;
//        this.datacenterId = datacenterId;
//    }
//
//    //生成id
//    public synchronized long nextId() {
//        long timestamp = timeGen();
//        if (timestamp < lastTimestamp) {
//            throw new RuntimeException(
//                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
//        }
//        //如果是同一时间生成的，则自增
//        if (timestamp == lastTimestamp) {
//            sequence = (sequence + 1) & sequenceMask;
//            if (sequence == 0) {
//                //生成下一个毫秒级的序列
//                timestamp = tilNextMillis();
//                //序列从0开始
//                sequence = 0L;
//            }
//        } else {
//            //如果发现是下一个时间单位，则自增序列回0，重新自增
//            sequence = 0L;
//        }
//
//        lastTimestamp = timestamp;
//
//        //看本文第二部分的结构图，移位并通过或运算拼到一起组成64位的ID
//        return ((timestamp - startTime) << timestampLeftShift)
//                | (datacenterId << datacenterIdLeftShift)
//                | (workerId << workerIdLeftShift)
//                | sequence;
//    }
//
//    protected long tilNextMillis() {
//        long timestamp = timeGen();
//        if (timestamp <= lastTimestamp) {
//            timestamp = timeGen();
//        }
//        return timestamp;
//    }
//
//    protected long timeGen() {
//        return System.currentTimeMillis();
//    }
//
//    class IdServiceThread implements Runnable {
//        private Set<Long> set;
//
//
//        public IdServiceThread(Set<Long> set, idWorkers idService) {
//            this.set = set;
//            this.idService = idService;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                long id = idService.nextId();
//                System.out.println("duplicate:" + id);
//                if (!set.add(id)) {
//                    System.out.println("duplicate:" + id);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Set<Long> set = new HashSet<Long>();
//        IdWorker idWorkers = new IdWorker();
//        for (int i = 0; i < 100; i++) {
//            Thread t1 = new Thread(new IdServiceThread(set, idService));
//            t1.setDaemon(true);
//            t1.start();
//            try {
//                Thread.sleep(30000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
