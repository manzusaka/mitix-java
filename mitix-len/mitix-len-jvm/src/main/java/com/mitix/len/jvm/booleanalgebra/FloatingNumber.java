package com.mitix.len.jvm.booleanalgebra;

/**
 * @author oldflame-jm
 * @since 1.0.0
 * <p>
 * java浮点数的表示方法准守IEEE 754
 * 浮点数分单精度和双精度
 * <p>
 * 请看深入理解计算机原理  P3
 * <p>
 * 下面展示了浮点数的额二进制表示
 *
 * 这个少几位不知道什么意思还要研究一下
 */
public class FloatingNumber {
    public static void main(String[] args) {
        float f = 0.4f;
        double d = 0.4;

        int fb = Float.floatToRawIntBits(f);
        System.out.println(Integer.toBinaryString(fb));
        long ld = Double.doubleToLongBits(d);
        System.out.println(Long.toBinaryString(ld));

    }
}
