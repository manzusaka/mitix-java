package com.mitix.len.ooad.filter.exp2;

/**
 * 
 * 创建于:2016年9月10日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class FilterTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String msgrequest = "i am request";
    String msgresponse = "i am response";
    Request request = new Request();
    request.setRequestStr(msgrequest);
    Response response = new Response();
    response.setResponseStr(msgresponse);

    FilterChain fc = new FilterChain();
    fc.addFilter(new HelloFilter()).addFilter(new DaDaFilter()).addFilter(new HaHaFilter());
    fc.doFilter(request, response, fc);
    System.out.println(request.getRequestStr());
    System.out.println(response.getResponseStr());

  }

}
