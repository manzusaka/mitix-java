package com.mitix.len.ooad.memento.exp2;

/**
 * 创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Originator {
  private String state;

  public Originator() {

  }

  public MementoInfo createMemento() {
    return new Memento(this.state);
  }

  public void restoreMemento(MementoInfo memento) {
    Memento tMemento = (Memento) memento;
    this.state = tMemento.getState();
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
    System.out.println("now  set current state=" + this.state);
  }

  public class Memento implements MementoInfo {

    private String saveState;

    private Memento(String state) {
      this.saveState = state;
    }

    private String getState() {
      return saveState;
    }

    @SuppressWarnings("unused")
    private void setState(String state) {
      this.saveState = state;
    }

  }

}
