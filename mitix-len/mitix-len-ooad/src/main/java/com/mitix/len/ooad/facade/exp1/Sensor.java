package com.mitix.len.ooad.facade.exp1;

import java.util.UUID;

public class Sensor {
  private String sensorId;

  private Sensor(String sensorId) {
    this.sensorId = sensorId;
  }

  public static Sensor getInstance() {
    String tid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    return new Sensor(tid);
  }

  public void activate() {
    System.out.println("activating the sensor");
  }

  public void deactivate() {
    System.out.println("deactivating the sensor");
  }

  public void trigger() {
    System.out.println("trigger this sensor");
  }

  public String getSensorId() {
    return sensorId;
  }

}
