package com.mitix.len.ooad.filter.exp2;

public class HaHaFilter implements Filter {

  public void doFilter(Request request, Response response, FilterChain chain) {
    request.setRequestStr(request.getRequestStr()+"---HaHa request");
    chain.doFilter(request, response, chain);
    response.setResponseStr(response.getResponseStr()+"---HaHa response");
  }

}
