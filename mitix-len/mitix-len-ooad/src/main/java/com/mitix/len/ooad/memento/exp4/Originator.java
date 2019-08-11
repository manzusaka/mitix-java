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
public class Originator {
  // 这个也可以用其他的类型结构 比如ArrayList
  private HashMap<String, String> state;

  public Originator() {
    this.state = new HashMap<String, String>();
  }

  public MementoInfo createMemento() {
    return new Memento(state);
  }

  public void restoreMemento(MementoInfo memento) {
    Memento tMemento = (Memento) memento;
    this.state = tMemento.getState();
  }

  public void showState() {
    System.out.println("now state=" + state.toString());
  }

  public void testState1() {
    state.put("blood", "500");
    state.put("progress", "step3");
    state.put("enemy", "5");
  }

  public void testState2() {
    state.put("blood", "450");
    state.put("progress", "step4");
    state.put("enemy", "3");
  }

  public class Memento implements MementoInfo {

    private HashMap<String, String> saveState;

    // 注意 这个是应为要保存状态 所以必须使用new 不然指向引用会是同一个state对象
    private Memento(HashMap<String, String> state) {
      this.saveState = new HashMap<String, String>(state);
    }

    private HashMap<String, String> getState() {
      return saveState;
    }

    @SuppressWarnings("unused")
    private void setState(HashMap<String, String> state) {
      this.saveState = state;
    }

  }

}
