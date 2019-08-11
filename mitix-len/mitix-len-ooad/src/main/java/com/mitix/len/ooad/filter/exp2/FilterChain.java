package com.mitix.len.ooad.filter.exp2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 创建于:2016年9月10日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class FilterChain implements Filter {
  //这个地方需要注意多线程  我记得多线程是有这个东西的
  private Deque<Filter> reqArrayDeque = new ArrayDeque<Filter>();


  public FilterChain addFilter(Filter filter) {
    this.reqArrayDeque.addFirst(filter);
    return this;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.atdz.footprint.designpatterns.filter.Filter#doFilter(com.atdz.footprint.designpatterns.
   * filter.Request, com.atdz.footprint.designpatterns.filter.Response)
   */
  public void doFilter(Request request, Response response, FilterChain chain) {
    while (reqArrayDeque.size() > 0) {
      Filter filter = reqArrayDeque.pollFirst();
      filter.doFilter(request, response, chain);
    }
  }

  public Deque<Filter> getReqArrayDeque() {
    return reqArrayDeque;
  }

}
