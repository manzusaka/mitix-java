package com.mitix.len.ooad.template.exp1;

/**
 * 创建于:2016年10月11日<br>
 * GPL 2016 a code farmer<br>
 * 热饮料   抽象的一个类  提供了泡热饮料的模板方法
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public abstract class HotDrink {

  //泡热饮料的步骤
  public final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    addComdiment();
  }
  
  // 烧水
  public void boilWater() {
    System.out.println("烧水");
  }

  // 冲泡方法
  protected abstract void brew();

  // 材料放入杯子
  public void pourInCup() {
    System.out.println("放入杯子");
  }

  // 加特殊调料
  protected abstract void addComdiment();
}
