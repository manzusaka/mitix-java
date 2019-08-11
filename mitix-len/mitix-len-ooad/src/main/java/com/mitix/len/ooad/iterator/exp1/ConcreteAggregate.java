package com.mitix.len.ooad.iterator.exp1;

/**
 * 创建于:2016年10月16日<br>
 * GPL 2016 a code farmer<br>
 * 聚集角色的实现
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class ConcreteAggregate extends Aggregate {

  private Object[] objArray = null;

  /**
   * 构造方法，传入聚合对象的具体内容
   */
  public ConcreteAggregate(Object[] objArray) {
    this.objArray = objArray;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Aggregate#createIterator()
   */
  @Override
  public Iterator createIterator() {
    return new ConcreteIterator(this);
  }


  /**
   * 取值方法：向外界提供聚集元素
   */
  public Object getElement(int index) {

    if (index < objArray.length) {
      return objArray[index];
    } else {
      return null;
    }
  }

  /**
   * 取值方法：向外界提供聚集的大小
   */
  public int size() {
    return objArray.length;
  }
}
