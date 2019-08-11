package com.mitix.len.ooad.observer.exp4;

import java.util.EventListener;

/**
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 事件监听接口   观察者
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public interface SwitchListener extends EventListener{

  public void handleEvent(SwitchEvent switchEvent) throws RuntimeException;

}
