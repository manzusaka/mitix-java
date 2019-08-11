package com.mitix.len.ooad.observer.exp1;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建于:2016年8月20日<br>
 * GPL 2016 a code farmer<br>
 * 目标对象 --目标对象知道那些观察者在观察他 提供注册 和删除观察者的方法
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Subject {
  /**
   * 观察者对象数组
   */
  private List<ObServer> obServerList = new ArrayList<ObServer>();
  /**
   * 状态
   */
  private String subjectState;

  public String getSubjectState() {
    return subjectState;
  }

  public void setSubjectState(String subjectState) {
    this.subjectState = subjectState;
  }

  // private final ReentrantLock lock = new ReentrantLock();
  /**
   * 注册观察者对象（订阅操作）
   * 
   * @param observer
   */
  public void attach(ObServer observer) {
    synchronized (observer) {
      this.obServerList.add(observer);
    }
  }

  /**
   * 取消注册观察者（感觉可以理解为取消订阅）
   * 
   * @param observer
   */
  public void detach(ObServer observer) {
    synchronized (observer) {
      this.obServerList.remove(observer);
    }
  }

  /**
   * 通知所有的观察者对象
   */
  protected void notifyObServer() {
    for (ObServer observer : obServerList) {
      observer.update(this);
    }
  }


}
