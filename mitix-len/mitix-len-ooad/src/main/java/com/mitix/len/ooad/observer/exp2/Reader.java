package com.mitix.len.ooad.observer.exp2;

/**
 * 
 *创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 观察对象   主动对象
 * @author infoconsole
 * @version TODO
 */
public class Reader implements Observer {
  private String name;

  // 拉模型获取数据 传输过来的是对象地址 然后根据需要自己去取
  public void update(@SuppressWarnings("rawtypes") Subject subject) {
    System.out.println("拉模型 报纸已经到了----" + name + "快来看报纸了----" + "内容是----" + subject.getT());
  }

  // 这个是一个推模型
  public <T> void update2(T t) {
    System.out.println("推模型  报纸已经到了----" + name + "快来看报纸了----" + "内容是----" + t);

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



}
