package com.mitix.len.ooad.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

  protected MyRemoteImpl() throws RemoteException {
    super();
  }

  /**
   * 
   */
  private static final long serialVersionUID = 7920270102431302499L;

  /*
   * (non-Javadoc)
   * 
   * @see MyRemote#sayHello()
   */
  public String sayHello() throws RemoteException {
    return "Hello world";
  }
  
  public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
    MyRemote service = new MyRemoteImpl();
    LocateRegistry.createRegistry(6600);
    Naming.bind("rmi://127.0.0.1:6600/MyRemote.sayHello",service);
  }
}
