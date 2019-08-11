/**
 * 创建于:2016年10月11日<br>
 * GPL 2016 a code farmer<br>
 * 简单的模板模式
 * 
 * @author infoconsole
 * @version 1.0.0
 */
package com.mitix.len.ooad.template.exp2;
//1.在模板抽象类（父类）  封装一个算法步骤     一个或者多个final方法    
//2.父类可以实现通用的几个步骤   （这个步骤可以根据情况判断是否提供给子类进行覆盖）
//3.子类实现几个特殊的方法


//模板模式中  模板类中模板方法分三类
//1.抽象方法  protected abstract 这样的方法必须由子类实现  
//2.模板方法   一般是public  final   对外公开  final不允许修改的   这个主要是因为模板开始就基本已经固定了
//3.钩子方法  已经实现的方法   protected 方法  子类可以覆盖    这个可以提供子类个性化修改  也可以模式使用父类的 
//  （钩子方法其实就是一个判断  需不需要进行哪个步骤  灵活性高）
//钩子方法一般以do开头
