package com.mitix.len.ooad.builder.exp1;

/**
 * 创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class Director {
    private Builder builder;

    public Product construct() {
        builder = new ConcreteBuilder().setName("info").setDoot("dodo").setLalaPro("ok");
        builder.buildPart1();
        builder.buildPart2();
        return builder.retrieveResult();
    }

}
