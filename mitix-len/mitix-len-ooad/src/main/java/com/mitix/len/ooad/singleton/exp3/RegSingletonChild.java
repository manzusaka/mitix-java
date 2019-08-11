/**
 * 
 */
package com.mitix.len.ooad.singleton.exp3;

/**
 * 创建于:2016年10月2日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class RegSingletonChild extends RegSingleton {
  public RegSingletonChild() {

  }

  public static RegSingletonChild getInstance() {
    return (RegSingletonChild) RegSingleton
        .getInstance("om.mitix.len.ooad.singleton.exp3.RegSingletonChild");
  }
}
