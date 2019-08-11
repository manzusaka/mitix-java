/**
 *
 */
package com.mitix.len.ooad.factorymethd.exp1;

/**
 * 创建于:2016年9月16日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version 1.0.0
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        VehicleFactory vf = new CarFactory();
        Moveable mable = vf.create(Test.class);
        System.out.println(mable.toString());
        mable.run();
    }

}
