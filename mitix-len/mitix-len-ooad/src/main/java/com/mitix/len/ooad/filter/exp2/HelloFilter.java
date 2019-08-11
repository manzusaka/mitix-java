package com.mitix.len.ooad.filter.exp2;

public class HelloFilter implements Filter {

  public void doFilter(Request request, Response response, FilterChain chain) {
    request.setRequestStr(request.getRequestStr()+"---Hello request");
    chain.doFilter(request, response, chain);
    response.setResponseStr(response.getResponseStr()+"---Hello response");
  }

}
