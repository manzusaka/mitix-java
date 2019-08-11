/*
 * Copyright (c) 2010
 * @date 2016
 * @author oldflame-Jm
 *
 * Apache License Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */
package com.mitix.len.jdk8base.pluralextends.exp2;

/**
 * @author oldflame-Jm TODO
 * @version 1.0.0
 */
public class SonImpl implements Son {

    /*
     * (non-Javadoc)
     *
     * @see pluralextends.Father#sayHaha()
     */
    public void sayHaha() {
        System.out.println("这是爸爸的哈哈");

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Father father = new SonImpl();
        father.sayHaha();
        Mother mother = new SonImpl();
        mother.sayhehe();

    }

    public void sayhehe() {
        System.out.println("这是妈妈的呵呵");

    }

}
