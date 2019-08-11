package com.mitix.len.ooad.command.exp2.commond;

import com.mitix.len.ooad.command.exp2.receiver.Light;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class LightOnCommond implements Commond {
  private Light light;

  public LightOnCommond(Light light) {
    this.light = light;
  }

  public void execute() {
    light.turnOn();
  }
  public void undo() {
    // TODO Auto-generated method stub

  }

}
