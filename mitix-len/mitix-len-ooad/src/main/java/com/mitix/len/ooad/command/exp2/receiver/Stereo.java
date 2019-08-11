package com.mitix.len.ooad.command.exp2.receiver;
/**
 * 
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * CD 命令模式执行者
 * @author infoconsole
 * @version 1.0.0
 */
public class Stereo {
  private int volume = 0;
  private String loc = "";

  public Stereo(String loc) {
    this.loc = loc;
  }

  public void turnOn() {
    System.out.println(loc + " Stereo is on ");
  }

  public void trunOff() {
    System.out.println(loc + " Stereo is off ");
  }

  public void setCd() {
    System.out.println(loc + " Stereo is setCd ");
  }

  public void setVol(int vol) {
    this.volume = vol;
    System.out.println(loc + " Stereo set vol= " + volume);
  }

  public void setStart() {
    System.out.println(loc + " Stereo is setStart ");
  }
}
