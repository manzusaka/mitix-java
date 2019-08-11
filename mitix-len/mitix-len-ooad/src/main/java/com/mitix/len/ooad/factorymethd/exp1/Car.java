/**
 *
 */
package com.mitix.len.ooad.factorymethd.exp1;

import java.util.HashMap;

/**
 * 创建于:2016年9月16日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version 1.0.0
 */
public class Car implements Moveable {
    private static HashMap<Object, Car> carMap = new HashMap<Object, Car>();

    static {
        carMap.put(Car.class, new Car());
    }

    /**
     * 关闭对象的构造函数 保证外部类无法new这个对象
     */
    private Car() {

    }

    /**
     * 改方法用户提供给外界获取Car 但是获取Car的控制掌握在自己的手里
     *
     * @return
     */
    public static Car getInstance() {
        // 这里可以写很多限制逻辑
        return carMap.get(Car.class);
    }

    /**
     * 可以根据外界的代码对应产生汽车
     *
     * @param t
     * @return
     */
    public static Car getInstance(Object t) {
        if (carMap.get(t) == NULL_OBJECT) {
            carMap.put(t, new Car());
        }
        return carMap.get(t);
    }

    @Override
    public void run() {
        System.out.println("冒着烟嘟嘟嘟。。。");
    }

}
