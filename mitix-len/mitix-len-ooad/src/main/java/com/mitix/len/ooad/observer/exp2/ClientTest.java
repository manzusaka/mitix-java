package com.mitix.len.ooad.observer.exp2;

/**
 * 
 *创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 测试
 * @author infoconsole
 * @version 1.0.0
 */
public class ClientTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    NewPaper<String> paper=new NewPaper<String>();
    
    Reader zhangs=new Reader();
    zhangs.setName("zhangsan");
    
    Reader lis=new Reader();
    lis.setName("lisi");
    
    paper.attach(zhangs);
    paper.attach(lis);
    
    paper.setT("这是今天报纸的内容。。。。");
    paper.notifyObserver();
    paper.notifyObserver2();
  }

}
