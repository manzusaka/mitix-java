package com.mitix.len.ooad.observer.exp3;

/**
 * 创建于:2016年8月20日<br>
 * GPL 2016 a code farmer<br>
 * java 中的观察者实现  
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class ClientTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    NewsPaper paper = new NewsPaper();

    Reader zhangs = new Reader();
    zhangs.setName("zhangsan");

    Reader lis = new Reader();
    lis.setName("lisi");


    paper.addObserver(zhangs);
    paper.addObserver(lis);

    paper.setContext("娜扎过啦了");

  }

}
