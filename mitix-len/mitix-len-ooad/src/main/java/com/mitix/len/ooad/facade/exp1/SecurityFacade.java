package com.mitix.len.ooad.facade.exp1;

/**
 * 创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class SecurityFacade {
  private static Camera camera1 = Camera.getInstance();
  private static Camera camera2 = Camera.getInstance();
  private static Light light1 = Light.getInstance();
  private static Light light2 = Light.getInstance();
  private static Light light3 = Light.getInstance();
  private static Sensor sensor = Sensor.getInstance();
  private static Alarm alarm = Alarm.getInstance();

  public void activate() {
    camera1.turnOn();
    camera2.turnOn();
    light1.turnOn();
    light2.turnOn();
    light3.turnOn();
    sensor.activate();
    alarm.activate();
  }

  public void deactivate() {
    camera1.turnOff();
    camera2.turnOff();
    light1.turnOff();
    light2.turnOff();
    light3.turnOff();
    sensor.deactivate();
    alarm.deactivate();
  }
}
