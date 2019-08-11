package com.mitix.len.ooad.command.exp2.commond;

/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class MacroCommond implements Commond {
  private Commond[] commonds;
  
  public MacroCommond(Commond[] commonds) {
    this.commonds=commonds;
  }
  
  public void addCommond(Commond commond,int slot) {
    if(slot<commonds.length){
      commonds[slot]=commond;
    }
  }
  /* (non-Javadoc)
   * @see Commond#execute()
   */
  public void execute() {
    for(int i=0;i<commonds.length;i++){
      commonds[i].execute();
    }
  }

  /* (non-Javadoc)
   * @see Commond#undo()
   */
  public void undo() {
    // TODO Auto-generated method stub

  }

}
