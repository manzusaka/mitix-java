package com.mitix.len.jvm.booleanalgebra;

/**
 * @author oldflame-jm
 * @since 1.0.0
 * <p>
 * java中的布尔运算
 * 详见深入理解计算机原理中的布尔代数运算
 * 查看是否和C语言中的布尔运算是一样的
 */
public class BooleanOperation {
    public static void main(String[] args) {
        int a = 0x66;
        int b = 0x39;

        System.out.printf("x & y = %x\n", a & b);
        System.out.printf("x | y = %x\n", a | b);
        System.out.printf("~x | ~y = %x\n", ~a | ~b);
        System.out.printf("x ^ y = %x\n", a ^ b);

        //java中逻辑运算符不允许操作int类型  包括 && || !   C语言中可以操作

        //System.out.printf("x && y = %x\n", a && b);
        //System.out.printf("x || y = %x\n", a || b);
        //System.out.printf("!x || !y = %x\n", !a || !b);
        //System.out.printf("x && !y = %x\n", a && !b);
    }
}
