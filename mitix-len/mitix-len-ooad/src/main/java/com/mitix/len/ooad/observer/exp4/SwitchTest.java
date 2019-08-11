package com.mitix.len.ooad.observer.exp4;

/**
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 测试程序
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class SwitchTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Switch swith = new Switch();
    swith.addListener(new SwitchListener() {
      public void handleEvent(SwitchEvent switchEvent) {
        System.out.println("handle event1 and source=" + switchEvent.getSource());
        System.out.println("handle event1 and sourceId=" + switchEvent.getId());
        System.out.println("handle event1 and eventState=" + switchEvent.getSwitchState());
      }
    });
    swith.addListener(new SwitchListener() {
      public void handleEvent(SwitchEvent switchEvent) {
        System.out.println("handle event2 and source=" + switchEvent.getSource());
        System.out.println("handle event2 and eventId=" + switchEvent.getId());
        System.out.println("handle event2 and eventState=" + switchEvent.getSwitchState());
      }
    });

    // 触发
    swith.open();
    swith.close();
  }

}
