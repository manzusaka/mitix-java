package com.mitix.len.ooad.facade.exp1;

import java.util.UUID;

public class Alarm {
  private String alarmId;

  private Alarm(String alarmId) {
    this.alarmId = alarmId;
  }

  public static Alarm getInstance() {
    String tid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    return new Alarm(tid);
  }

  public void activate() {
    System.out.println("activating the alarm");
  }

  public void deactivate() {
    System.out.println("deactivating the alarm");
  }

  public void run() {
    System.out.println("runing this alarm");
  }

  public void stopRun() {
    System.out.println("stop runing alarm");
  }

  public String getAlarmId() {
    return alarmId;
  }

}
