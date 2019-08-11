package com.mitix.len.ooad.filter.exp2;

public class DaDaFilter implements Filter {

  public void doFilter(Request request, Response response, FilterChain chain) {
    request.setRequestStr(request.getRequestStr()+"---DaDa request");
    chain.doFilter(request, response, chain);
    response.setResponseStr(response.getResponseStr()+"---DaDa response");
    
  }

}
