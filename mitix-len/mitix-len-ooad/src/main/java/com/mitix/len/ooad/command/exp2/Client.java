package com.mitix.len.ooad.command.exp2;

import com.mitix.len.ooad.command.exp2.commond.Commond;
import com.mitix.len.ooad.command.exp2.commond.LightOffCommond;
import com.mitix.len.ooad.command.exp2.commond.LightOnCommond;
import com.mitix.len.ooad.command.exp2.invoker.ConcreteInvoker;
import com.mitix.len.ooad.command.exp2.invoker.Invoker;
import com.mitix.len.ooad.command.exp2.receiver.Light;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 客户端
 * 
 * @author infoconsole
 * @version TODO
 */
public class Client {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Light light = new Light("客厅灯");
    Commond onCommond = new LightOnCommond(light);
    Commond offCommond = new LightOffCommond(light);
    Invoker invoker=new ConcreteInvoker();
    invoker.setOnCommond(0, onCommond);
    invoker.setOffCommond(0, offCommond);
    
    invoker.onAction(0);
    invoker.offAction(0);
    invoker.onAction(1);
    invoker.offAction(1);
  }

}
