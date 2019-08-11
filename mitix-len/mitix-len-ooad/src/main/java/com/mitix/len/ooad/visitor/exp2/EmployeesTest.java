package com.mitix.len.ooad.visitor.exp2;

public class EmployeesTest {
  public static void main(String[] args) {
    Employees emps=new Employees();
    emps.add(new Employee("E1",30,1,5));
    emps.add(new Employee("E2",35,2,8));
    emps.add(new Employee("E1",40,3,10));
    emps.add(new Employee("E1",50,4,15));
    emps.Accept(new CompensationVisitor());
  }

}
