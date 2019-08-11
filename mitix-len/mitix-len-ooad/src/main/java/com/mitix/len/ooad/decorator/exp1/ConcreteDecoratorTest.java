package com.mitix.len.ooad.decorator.exp1;

public class ConcreteDecoratorTest {
    public static void main(String[] args) {
        Decorator decorator = new ConcreteDecorator(new ConcreteDecorator2(new ConcreteComponent()));
        decorator.sampleOperation();
    }
    

}
