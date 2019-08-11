/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 一个简单的责任链模式 
 * 
 * @author infoconsole
 * @version 1.0.0
 */
package com.mitix.len.ooad.filter.exp1;
//其实就是设置处理的实际Handler  只要由Handler就往下传递

//1.一个纯的责任链模式  要求要求具体处理对象只能有一个       就相当于这个例子里面的handler2  handler1如果直接把内容推给下家不进行处理   
//不允许出现承担了部分责任以后再把责任又传递给下家
//2.一个纯的责任链  请求必须被一个对象处理
