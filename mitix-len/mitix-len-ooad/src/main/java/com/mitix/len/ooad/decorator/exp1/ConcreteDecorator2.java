package com.mitix.len.ooad.decorator.exp1;

/**
 * 创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {
        System.out.println("咕噜咕噜咕噜");
        super.sampleOperation();
    }
}
