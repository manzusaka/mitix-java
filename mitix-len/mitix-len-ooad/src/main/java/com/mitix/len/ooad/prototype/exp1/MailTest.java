package com.mitix.len.ooad.prototype.exp1;

public class MailTest {
  public static void main(String[] args) {
    {
      MailTest test=new MailTest();
      int i = 0;
      int MAX_COUNT = 10;
      EventTemplate et = new EventTemplate("9月账单", "银泰打折");
      Mail mail = new Mail(et);

      while (i++ < MAX_COUNT) {
        Mail cloneMail = mail.clone();
        cloneMail.setTail("XX" + i + "先生（女士）：你的账单。。。");
        cloneMail.setReceiver("xx" + i + "@xx.com");
        test.sendMail(cloneMail);
      }
    }
  }

  private void sendMail(Mail mail) {
    StringBuilder sb = new StringBuilder();
    sb.append("subject=[" + mail.getSubject() + "]").append("receiver=[" + mail.getReceiver() + "]").append("context=[" + mail.getContext() + "]").append("tail=[" + mail.getTail() + "]");
    System.out.println(sb.toString());
  }

}
