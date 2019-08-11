package com.mitix.len.ooad.observer.exp4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 目标对象 --控制开关(被观察的对象   开关)    
 * @author infoconsole
 * @version 1.0.0
 * @param <E>
 */
public class Switch {
  
  private List<Object> switchListenerList=new ArrayList<Object>();
  
  public void addListener(Object listener) {
      switchListenerList.add(listener);
  }
  
  public void rmListener(Object listener){
    switchListenerList.remove(listener);
  }
  protected void open() {
      SwitchEvent switchEvent = new SwitchEvent(this, "开");
      notifyListeners(switchEvent);
  }

  protected void close() {
      SwitchEvent switchEvent = new SwitchEvent(this, "关");
      notifyListeners(switchEvent);
  }

  private void notifyListeners(SwitchEvent switchEvent) {
      @SuppressWarnings("rawtypes")
      Iterator iterator = switchListenerList.iterator();
      while (iterator.hasNext()) {
          SwitchListener switchListener = (SwitchListener) iterator.next();
          switchListener.handleEvent(switchEvent);
      }
  }

}
