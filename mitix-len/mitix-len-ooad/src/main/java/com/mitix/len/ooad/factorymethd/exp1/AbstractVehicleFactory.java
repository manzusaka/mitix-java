package com.mitix.len.ooad.factorymethd.exp1;

/**
 *创建于:2016年9月18日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public abstract class AbstractVehicleFactory {

  protected abstract Moveable create();
  
  protected abstract Moveable create(Object t);

}
