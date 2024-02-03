package com.mitix.len.algorithm.bitmap;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class BitMap {
    private byte[] bits;
    private static final int MASK = 3;
    private static final int maxNumber = (1 << MASK) - 1;
    private int capacity;

    public BitMap(int capacity) {
        //BitMap的容量
        this.capacity = capacity;
        //1bit能存储8个数据，那么capacity数据需要多少个bit呢，capacity/8+1,右移3位相当于除以8
        bits = new byte[(capacity >> 3) + 1];
    }

    public void add(int num) {
        // num/8得到byte[]的index
        int bitIndex = num >> 3;
        // num%8得到在byte[index]的位置
        int bitPosition = num & 0x07;
        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了
        bits[bitIndex] |= 1 << bitPosition;

    }

}