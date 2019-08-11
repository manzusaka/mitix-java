package com.mitix.len.ooad.decorator.exp1;

/**
 * 创建于:2016年10月30日<br>
 * GPL 2016 a code farmer<br>
 * 具体的装饰
 *
 * @author infoconsole
 * @version TODO
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {
        System.out.println("巴拉巴拉巴拉");
        super.sampleOperation();
    }
}
