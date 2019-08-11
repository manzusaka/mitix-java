package com.mitix.len.ooad.command.exp2.commond;

import com.mitix.len.ooad.command.exp2.receiver.Light;


/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class LightOffCommond implements Commond {
  private Light light;
  public LightOffCommond(Light light) {
    this.light=light;
  }
  /* (non-Javadoc)
   * @see Commond#execute()
   */
  public void execute() {
    light.turnOff();
  }

  public void undo() {
    
  }

}
