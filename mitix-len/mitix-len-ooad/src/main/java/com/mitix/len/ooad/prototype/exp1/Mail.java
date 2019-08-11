package com.mitix.len.ooad.prototype.exp1;

/**
 * 创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class Mail implements Cloneable {
    private String receiver;
    private String subject;
    private String context;
    private String tail;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public Mail(EventTemplate et) {
        this.subject = et.getEventSubject();
        this.context = et.getEventContext();
    }

    @Override
    public Mail clone() {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mail;
    }

}
