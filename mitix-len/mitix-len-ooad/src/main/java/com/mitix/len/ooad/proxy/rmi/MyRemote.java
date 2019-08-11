package com.mitix.len.ooad.proxy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public interface MyRemote extends Remote {
  
  public String sayHello() throws RemoteException;

}
