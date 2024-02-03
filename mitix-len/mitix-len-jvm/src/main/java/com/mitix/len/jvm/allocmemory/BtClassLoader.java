package com.mitix.len.jvm.allocmemory;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class BtClassLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader.registerAsParallelCapable();
        BtClassLoader classLoader = new BtClassLoader();


        classLoader.loadClass("com.mitix.len.jvm.classloader.SuperClass");
    }
}
