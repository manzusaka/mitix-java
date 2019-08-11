package com.mitix.len.ooad.command.exp2.invoker;

import com.mitix.len.ooad.command.exp2.commond.Commond;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public interface Invoker {
  public void setOnCommond(int slot, Commond onCommond);

  public void setOffCommond(int slot, Commond onCommond);

  public void offAction(int slot);

  public void onAction(int slot);
}
