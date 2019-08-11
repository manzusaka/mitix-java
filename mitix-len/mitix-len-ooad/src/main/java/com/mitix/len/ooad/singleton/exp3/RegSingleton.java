/**
 * 
 */
package com.mitix.len.ooad.singleton.exp3;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建于:2016年10月2日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class RegSingleton {
  private static Map<String, Object> registryMap = new HashMap<String, Object>();
  static {
    registryMap.put(RegSingleton.class.getName(), new RegSingleton());
  }

  // protected权限的默认构造
  protected RegSingleton() {

  }

  public static RegSingleton getInstance(String name) {
    if (name == null) {
      name = "RegSingleton";
    }
    synchronized (registryMap) {
      if (registryMap.get(name) == null) {
        try {
          registryMap.put(name, Class.forName(name).newInstance());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return (RegSingleton) registryMap.get(name);
  }
  
  
  //商业逻辑
  public void Hello(){
    System.out.println("GOOLE");
  }
}
