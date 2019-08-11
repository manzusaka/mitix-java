package com.mitix.len.ooad.filter.exp1;

/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class ConcreteHandler extends Handler {

  /* (non-Javadoc)
   * @see Handler#handleRequest()
   */
  @Override
  public void handleRequest() {
    if(getHandler()!=null){
      System.out.println("this request is pass to handle="+getHandler());
      getHandler().handleRequest();
    }else{
      System.out.println("this request is handled here");
    }

  }

}
