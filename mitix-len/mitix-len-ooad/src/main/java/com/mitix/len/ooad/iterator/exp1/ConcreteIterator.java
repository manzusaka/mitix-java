package com.mitix.len.ooad.iterator.exp1;

/**
 * 创建于:2016年10月16日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class ConcreteIterator implements Iterator {
  // 持有被迭代的具体的聚合对象
  private ConcreteAggregate agg;
  // 内部索引，记录当前迭代到的索引位置
  private int index = 0;
  // 记录当前聚集对象的大小
  private int size = 0;

  public ConcreteIterator(ConcreteAggregate agg) {
    this.agg = agg;
    this.size = agg.size();
    index = 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Iterator#first()
   */
  public void first() {
    index = 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Iterator#next()
   */
  public void next() {
    if (index < size) {
      index++;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see Iterator#isDone()
   */
  public boolean isDone() {
    return (index >= size);
  }

  /*
   * (non-Javadoc)
   * 
   * @see Iterator#currentItem()
   */
  public Object currentItem() {
    return agg.getElement(index);
  }

}
