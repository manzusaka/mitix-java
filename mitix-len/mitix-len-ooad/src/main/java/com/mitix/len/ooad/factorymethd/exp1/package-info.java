/**
 * 创建于:2016年9月10日<br>
 * GPL 2016 a code farmer<br>
 * 工厂方法模式
 * 
 * @author infoconsole
 * @version 1.0.0
 */
package com.mitix.len.ooad.factorymethd.exp1;
//要大家考虑     只给司机一辆车  (单例或者多例)
//2.任意定制交通工具的类型和生产过程


//工厂方法模式中有4个角色
// 1.抽象工厂   这里的VehicleFactory   工厂方法的核心，于应用程序是无关的   任何再模式中创建对象的工厂类必须实现这个接口
//（在现实情况这个类也很有可能是一个抽象方法，拿来继承使用，类似于AbstractVehicleFactory类）

//2.具体工厂  这里的CarFactory，PanFactory (实现抽象工厂的接口类VehicleFactory的方法，或者继承AbstractVehicleFactory实现方法)包含了于应用密切相关的业务逻辑

//3.抽象产品  工厂方法创建的产品类型的超类型，也就是产品拥有的共同接口（或者产品共同拥有的抽象父类）

//4.具体产品  这个类实现了抽象产品所声明的接口（或者实现父类的所有抽象方法，是一个实体类）

//5.这里的工厂可以是多个层级的  不一定是两级   同样的  产品也可以是多个层级的
