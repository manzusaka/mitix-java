package com.mitix.len.ooad.factorymethd.exp1;

import java.util.HashMap;

/**
 * 创建于:2016年9月18日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Pan implements Moveable {
  // 该方法可以设计成单例模式
  private static HashMap<Object, Pan> panMap = new HashMap<Object, Pan>();
  static {
    panMap.put(Pan.class, new Pan());
  }

  /**
   * 关闭对象的构造函数 保证外部类无法new这个对象
   */
  private Pan() {

  }

  /**
   * 改方法用户提供给外界获取Car 但是获取Car的控制掌握在自己的手里
   * 
   * @return
   */
  public static Pan getInstance() {
    // 这里可以写很多限制逻辑
    return panMap.get(Pan.class);
  }

  /**
   * 可以根据外界的代码对应产生汽车
   * 
   * @param t
   * @return
   */
  public static Pan getInstance(Object t) {
    if (panMap.get(t) == NULL_OBJECT) {
      panMap.put(t, new Pan());
    }
    return panMap.get(t);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.factory.exp2.Moveable#run()
   */
  @Override
  public void run() {
    System.out.println("扇着翅膀啪啪啪。。。");

  }

}
