package com.mitix.len.ooad.facade.exp1;

/**
 * 创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * 一个渣渣实现
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class BadClient {
  private static Camera camera1 = Camera.getInstance();
  private static Camera camera2 = Camera.getInstance();
  private static Light light1 = Light.getInstance();
  private static Light light2 = Light.getInstance();
  private static Light light3 = Light.getInstance();
  private static Sensor sensor = Sensor.getInstance();
  private static Alarm alarm = Alarm.getInstance();

  /**
   * @param args
   */
  public static void main(String[] args) {
    camera1.turnOn();
    camera2.turnOn();
    light1.turnOn();
    light2.turnOn();
    light3.turnOn();
    sensor.activate();
    alarm.activate();
  }

}
