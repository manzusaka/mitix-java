package com.mitix.len.ooad.facade.exp1;

import java.util.UUID;

public class Light {
  private String lightId;

  private Light(String lightId) {
    this.lightId = lightId;
  }

  public static Light getInstance() {
    String tid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    return new Light(tid);
  }

  public void turnOn() {
    System.out.println("turn on the Light");
  }

  public void turnOff() {
    System.out.println("trun off the Light");
  }


  public void changeBulb() {
    System.out.println("changeBulb the Light");
  }

  public String getLightId() {
    return lightId;
  }

}
