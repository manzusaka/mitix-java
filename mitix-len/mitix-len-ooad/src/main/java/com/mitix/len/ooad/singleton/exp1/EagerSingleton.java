/**
 * 
 */
package com.mitix.len.ooad.singleton.exp1;

/**
 * 创建于:2016年10月2日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class EagerSingleton {
  
  private static final EagerSingleton m_instance = new EagerSingleton();

  private EagerSingleton() {

  }

  public static EagerSingleton getInstance() {
    return m_instance;
  }
}
