package com.mitix.len.ooad.visitor.exp2;

import java.util.ArrayList;
import java.util.List;

/**
 *创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Employees{
  private List<Employee> emps=new ArrayList<Employee>();
  public void add(Employee employee){
    emps.add(employee);
  }
  
  public void remove(Employee employee){
    emps.remove(employee);
  }
  
  public void Accept(Visitor visitor){
    for(Employee emp:emps){
      emp.Accept(visitor);
    }
  }
}
