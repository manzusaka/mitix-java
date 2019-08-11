package com.mitix.len.ooad.abstractfactory;

public class DefaultFactoryTest {
  public static void main(String[] args) {
    DefaultFactory.setFactory(2);
    Apple apple = DefaultFactory.createApple();
    apple.grow();
    apple.applePlant();
    Strawberry strawberry = DefaultFactory.createStrawberry();
    strawberry.grow();
    strawberry.strawberryPlant();
  }

}
