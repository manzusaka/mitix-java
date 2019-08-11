package com.mitix.len.ooad.observer.exp2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 目标对象 --目标对象知道那些观察者在观察他 提供注册 和删除观察者的方法
 * 
 * @author infoconsole
 * @version 1.0.0
 * @param <T>
 */
public class Subject<T> {
  /**
   * 观察者对象数组
   */
  private List<Observer> observerList = new ArrayList<Observer>();
  /**
   * 报纸
   */
  private T t;

  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }

  private final ReentrantLock lock = new ReentrantLock();

  /**
   * 注册观察者对象（订阅操作）
   * 
   * @param observer
   */
  public void attach(Observer observer) {
    // synchronized (observer) {
    // this.observerList.add(observer);
    // }

    lock.lock();
    try {
      this.observerList.add(observer);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }

  }

  /**
   * 取消注册观察者（感觉可以理解为取消订阅）
   * 
   * @param observer
   */
  public void detach(Observer observer) {
    synchronized (observer) {
      this.observerList.remove(observer);
    }
  }

  /**
   * 通知所有的观察者对象
   */
  protected void notifyObserver() {
    for (Observer observer : observerList) {
      observer.update(this);
    }
  }

  /**
   * 通知所有的观察者对象
   */
  protected void notifyObserver2() {
    for (Observer observer : observerList) {
      observer.update2(this.getT());
    }
  }



}
