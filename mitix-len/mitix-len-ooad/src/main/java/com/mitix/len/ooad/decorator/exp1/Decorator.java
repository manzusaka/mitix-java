package com.mitix.len.ooad.decorator.exp1;

/**
 * 创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * 装饰角色
 *
 * @author infoconsole
 * @version TODO
 */
public class Decorator implements Component {
    private Component component;

    public Decorator() {

    }

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        component.sampleOperation();
    }

}
