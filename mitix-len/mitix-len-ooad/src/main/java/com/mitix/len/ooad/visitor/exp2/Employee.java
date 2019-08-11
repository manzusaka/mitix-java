package com.mitix.len.ooad.visitor.exp2;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Employee extends Element {
  private String name;
  private Integer age;
  private Integer jibie;
  private Integer nianjia;
  
  public Employee(String name,Integer age,Integer jibie,Integer nianjia){
    this.name=name;
    this.age=age;
    this.jibie=jibie;
    this.nianjia=nianjia;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getJibie() {
    return jibie;
  }

  public void setJibie(Integer jibie) {
    this.jibie = jibie;
  }

  public Integer getNianjia() {
    return nianjia;
  }

  public void setNianjia(Integer nianjia) {
    this.nianjia = nianjia;
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see Element#Accept(Visitor)
   */
  @Override
  public void Accept(Visitor visitor) {
    visitor.visit(this);
  }

}
