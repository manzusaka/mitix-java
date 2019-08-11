package com.mitix.len.ooad.observer.exp3;

import java.util.Observable;
import java.util.Observer;

/**
 * 创建于:2016年8月21日<br>
 * GPL 2016 a code farmer<br>
 * java关于观察者的实现
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Reader implements Observer {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
   */
  public void update(Observable o, Object arg) {
    System.out.println("那个谁谁" + this.getName() + "推模型   本期内容" + arg);
    System.out.println("那个谁谁" + this.getName() + "拉模型   本期内容" + ((NewsPaper) o).getContext());

  }

}
