package com.mitix.len.ooad.simplefactory.exp2;

/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class Creater {
    /**
     * 静态工厂
     *
     * @return
     */
    public static ConcreteProduct create() {
        return new ConcreteProduct();
    }
}
