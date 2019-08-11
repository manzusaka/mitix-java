/**
 * 
 */
package com.mitix.len.ooad.singleton.exp2;

/**
 * 创建于:2016年10月2日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class EagerSingleton {

  private static EagerSingleton m_instance = null;

  private EagerSingleton() {

  }
  
  public static EagerSingleton getInstance() {
    synchronized (m_instance) {
      if (m_instance == null) {
        m_instance = new EagerSingleton();
      }
      return m_instance;
    }
  }
}
