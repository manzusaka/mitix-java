package com.mitix.len.jvm.allocmemory;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class Byteode4javap {
    public boolean bool;
    private char c = 'c';
    private double d = 66.00d;
    private float f = 2.3f;
    private int year;
    private long llago = 998888888L;
    private String stra = new String();
    private User[] arrs = new User[10];

    public void testMed() {
        int i = 0;
        i++;
        year++;
        System.out.println("this is i " + i);
    }

    public class User {
        String name = "local";
    }
}
