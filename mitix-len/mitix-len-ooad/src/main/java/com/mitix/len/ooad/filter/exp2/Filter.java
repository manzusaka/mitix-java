package com.mitix.len.ooad.filter.exp2;


/**
 *创建于:2016年9月10日<br>
 * GPL 2016 a code farmer<br>
 * 简单的责任链
 * @author infoconsole
 * @version 1.0.0
 */
public interface Filter {
  public void doFilter(Request request, Response response, FilterChain chain);
}
