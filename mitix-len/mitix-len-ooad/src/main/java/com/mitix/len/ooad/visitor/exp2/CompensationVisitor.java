package com.mitix.len.ooad.visitor.exp2;

/**
 * 
 *创建于:2016年11月13日<br>
 * GPL 2016 a code farmer<br>
 * 具体访问者
 * @author infoconsole
 * @version TODO
 */
public class CompensationVisitor implements Visitor {

  public void visit(Element element) {
    
    Employee employee=(Employee)element;
    System.out.println("Compensation is "+(employee.getJibie()*employee.getNianjia()*100));
  }

}
