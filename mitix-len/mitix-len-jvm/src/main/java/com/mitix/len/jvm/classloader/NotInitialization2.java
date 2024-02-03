package com.mitix.len.jvm.classloader;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[10];
        //this.getClass().getClassLoader().loadClass("xxx.class");
    }
}
