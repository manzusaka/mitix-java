package com.mitix.len.concurrent;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class BitOperator {
    public static void main(String[] args) {
        int a = 88;
        int b = 41;
        System.out.printf("a binary = %x\n b binary = %x\n a & b binary = %x\n a & b = %d \n", a, b, a & b, a & b);

        //第一层循环控制的是行数
        for (int i = 1; i <= 5; i++) {
            //打印空格数
            for (int j = 5; j > i; j--) {

                System.out.print(" ");
            }

            //打印*号数
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }
}
