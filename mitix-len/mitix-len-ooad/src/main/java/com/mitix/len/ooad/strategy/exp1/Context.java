package com.mitix.len.ooad.strategy.exp1;

/**
 * 创建于:2016年10月7日<br>
 * GPL 2016 a code farmer<br>
 * 环境角色  持有一个 策略的引用
 * 
 * @author infoconsole
 * @version TODO
 */
public class Context {
  private Strategy strategy;

  public void contextInterface() {
    strategy.strategyInterface();
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
