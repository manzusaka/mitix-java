package com.mitix.len.ooad.factorymethd.exp1;

/**
 *创建于:2016年9月18日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class CarFactory implements VehicleFactory {

  /* (non-Javadoc)
   * @see com.mitix.len.ooad.factory.exp2.VehicleFactory#create()
   */
  @Override
  public Moveable create() {
    return Car.getInstance();
  }
  
  /*
   * (non-Javadoc)
   * @see com.mitix.len.ooad.factory.exp2.VehicleFactory#create(java.lang.Object)
   */
  @Override
  public Moveable create(Object t) {
    return Car.getInstance(t);
  }

}
