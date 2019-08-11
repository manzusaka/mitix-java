package com.mitix.len.ooad.command.exp2.commond;

import com.mitix.len.ooad.command.exp2.receiver.Stereo;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class StereOnCommond implements Commond {
  private Stereo stereo;

  public StereOnCommond(Stereo stereo) {
    this.stereo = stereo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Commond#execute()
   */
  public void execute() {
    stereo.turnOn();
    stereo.setCd();

  }

  /*
   * (non-Javadoc)
   * 
   * @see Commond#undo()
   */
  public void undo() {
    // TODO Auto-generated method stub

  }

}
