package com.mitix.len.ooad.factorymethd.exp1;

/**
 * 创建于:2016年9月18日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public interface VehicleFactory {

    public Moveable create();

    public Moveable create(Object t);

}
