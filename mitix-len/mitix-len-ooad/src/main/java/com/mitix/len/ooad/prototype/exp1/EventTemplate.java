package com.mitix.len.ooad.prototype.exp1;

/**
 * 创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class EventTemplate {
  private String eventSubject;
  private String eventContext;

  public EventTemplate(String eventSubject, String eventContext) {
    this.eventContext = eventContext;
    this.eventSubject = eventSubject;
  }

  public String getEventSubject() {
    return eventSubject;
  }

  public String getEventContext() {
    return eventContext;
  }

}
