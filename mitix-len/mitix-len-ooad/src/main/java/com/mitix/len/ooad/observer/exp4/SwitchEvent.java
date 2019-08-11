package com.mitix.len.ooad.observer.exp4;

import java.util.EventObject;

/**
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 事件对象 继承自EventObject
 * 具体的开关事件
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class SwitchEvent extends EventObject {
  private static final long serialVersionUID = 1833205860362548413L;
  private String id = identityToString(this);
  private String switchState; // 表示开关的状态
  
  public SwitchEvent(Object source, String switchState) {
    super(source);
    this.switchState = switchState;
  }
  
  public String getSwitchState() {
    return switchState;
  }

  public void setSwitchState(String switchState) {
    this.switchState = switchState;
  }


  public static String identityToString(Object obj) {
    if (obj == null) {
      return "";
    }
    return obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


}
