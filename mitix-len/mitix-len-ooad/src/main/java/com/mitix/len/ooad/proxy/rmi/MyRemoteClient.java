package com.mitix.len.ooad.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class MyRemoteClient {

  /**
   * @param args
   * @throws NotBoundException 
   * @throws RemoteException 
   * @throws MalformedURLException 
   */
  public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
    MyRemote service=(MyRemote)Naming.lookup("rmi://127.0.0.1:6600/MyRemote.sayHello");
    System.out.println(service.sayHello());

  }

}
