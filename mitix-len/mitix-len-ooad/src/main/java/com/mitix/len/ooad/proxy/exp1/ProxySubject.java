package com.mitix.len.ooad.proxy.exp1;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class ProxySubject implements Subject {
    private RealSubject realSubject;


    public ProxySubject() {

    }

    private void afterRequest() {
        System.out.println("执行代理前置方法！！！");
    }

    private void beforeRequest() {
        System.out.println("执行代理后置方法！！！");
    }

    /*
     * (non-Javadoc)
     *
     * @see Subject#request()
     */
    @Override
    public void request() {
        beforeRequest();
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
        afterRequest();
    }

}
