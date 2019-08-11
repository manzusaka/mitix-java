package com.mitix.len.ooad.iterator.exp2;

/**
 * 创建于:2016年10月16日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Client {
  public void operation() {
    Object[] objArray = {"One", "Two", "Three", "Four", "Five", "Six"};
    // 创建聚合对象
    Aggregate agg = new ConcreteAggregate(objArray);
    // 循环输出聚合对象中的值
    Iterator it = agg.createIterator();
    while (!it.isDone()) {
      System.out.println(it.currentItem());
      it.next();
    }
  }

  public static void main(String[] args) {
    Client client = new Client();
    client.operation();
  }
}
