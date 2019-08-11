package com.mitix.len.ooad.memento.exp4;

public class Client {
  public static void main(String[] args) {
    Caretaker c=new Caretaker();
    Originator o=new Originator();
    
    o.testState1();
    c.saveMemento("step1", (MementoInfo) o.createMemento());
    o.showState();
    o.testState2();
    c.saveMemento("step2", (MementoInfo) o.createMemento());
    o.showState();
    o.restoreMemento(c.retrieveMemento("step1"));
    o.showState();
    o.restoreMemento(c.retrieveMemento("step2"));
    o.showState();
  }

}
