package com.mitix.len.ooad.facade.exp1;

import java.util.UUID;

/**
 * 创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * 录像机类
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Camera {
  private String camId;

  private Camera(String camId) {
    this.camId = camId;
  }

  public static Camera getInstance() {
    String tid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    return new Camera(tid);
  }

  public void turnOn() {
    System.out.println("turn on the Camera");
  }

  public void turnOff() {
    System.out.println("trun off the Camera");
  }

  public void rotate() {
    System.out.println("rotate the Camera");
  }

  public String getCamId() {
    return camId;
  }

}
