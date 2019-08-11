package com.mitix.len.ooad.observer.exp1;

/**
 * 创建于:2016年8月20日<br>
 * GPL 2016 a code farmer<br>
 * 具体的业务对象 负责把状态传给相应的观察者
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class ConcreteSubject extends Subject {

  @Override
  public void setSubjectState(String subjectState) {
    super.setSubjectState(subjectState);
//    this.notifyObServer();
  }


}
