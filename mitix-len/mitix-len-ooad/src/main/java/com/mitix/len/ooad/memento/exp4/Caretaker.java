package com.mitix.len.ooad.memento.exp4;

import java.util.HashMap;

/**
 * 创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Caretaker {
  private HashMap<String, MementoInfo> memento;

  public Caretaker() {
    this.memento = new HashMap<String, MementoInfo>();
  }

  public MementoInfo retrieveMemento(String info) {
    return memento.get(info);
  }

  public void saveMemento(String info, MementoInfo minfo) {
    this.memento.put(info, minfo);
  }

  public HashMap<String, MementoInfo> getMemento() {
    return this.memento;
  }

  public void setMemento(HashMap<String, MementoInfo> memento) {
    this.memento = memento;
  }
}
