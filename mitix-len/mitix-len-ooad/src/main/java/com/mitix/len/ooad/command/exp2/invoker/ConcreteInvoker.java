package com.mitix.len.ooad.command.exp2.invoker;

import com.mitix.len.ooad.command.exp2.commond.Commond;
import com.mitix.len.ooad.command.exp2.commond.NoCommond;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 命令的传递者 就是遥控器
 * 
 * @author infoconsole
 * @version TODO
 */
public class ConcreteInvoker implements Invoker {
  private Commond[] onCommonds;
  private Commond[] offCommonds;

  {
    onCommonds = new Commond[5];
    offCommonds = new Commond[5];
    Commond noCommond = new NoCommond();
    for (int i = 0; i < onCommonds.length; i++) {
      onCommonds[i] = noCommond;
    }
    for (int i = 0; i < offCommonds.length; i++) {
      offCommonds[i] = noCommond;
    }
  }

  public void setOnCommond(int slot, Commond onCommond) {
    if (slot >= onCommonds.length) {
      System.out.println("setOnCommond 不支持这个命令按钮");
    } else {
      onCommonds[slot] = onCommond;
    }
  }

  public void setOffCommond(int slot, Commond onCommond) {
    if (slot >= offCommonds.length) {
      System.out.println("setOffCommond 不支持这个命令按钮");
    } else {
      offCommonds[slot] = onCommond;
    }
  }

  public void onAction(int slot) {
    if (slot >= onCommonds.length) {
      System.out.println("onAction 没有这个按钮");
    } else {
      onCommonds[slot].execute();
    }
  }

  public void offAction(int slot) {
    if (slot >= offCommonds.length) {
      System.out.println("offAction 没有这个按钮");
    } else {
      offCommonds[slot].execute();
    }
  }
}
