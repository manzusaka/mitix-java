package com.mitix.len.ooad.statepatterm.exp1;

/**
 *创建于:2016年10月6日<br>
 * GPL 2016 a code farmer<br>
 * 环境角色
 * 定义客户端感兴趣的接口  并且保存一个具体状态类的实例
 * 这个具体状态类的实例给出了此环境对象现有的状态
 * @author infoconsole
 * @version 
 */
public class Context {
  private State state;
  
  public void sampleOperation(){
    state.sampleOperation();
  }
  
  public void setState(State state) {
    this.state = state;
  }

}
