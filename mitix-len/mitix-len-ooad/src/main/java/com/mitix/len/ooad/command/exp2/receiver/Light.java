package com.mitix.len.ooad.command.exp2.receiver;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 灯 命令的执行者
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Light {
  private String loc = "";

  public Light(String loc) {
    this.loc = loc;
  }

  public void turnOn() {
    System.out.println(loc + " is on ");
  }

  public void turnOff() {
    System.out.println(loc + " is off ");
  }
}
