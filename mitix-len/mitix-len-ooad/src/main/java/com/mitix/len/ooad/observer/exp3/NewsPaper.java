package com.mitix.len.ooad.observer.exp3;

import java.util.Observable;

/**
 * 创建于:2016年8月21日<br>
 * GPL 2016 a code farmer<br>
 * java中的观察者实现
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class NewsPaper extends Observable {
  private String context;

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;

    this.setChanged();
    // 拉模型
    // this.notifyObservers();
    // 推拉模型一起
    this.notifyObservers(this.context);
  }
}
