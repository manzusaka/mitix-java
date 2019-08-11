package com.mitix.len.ooad.statepatterm.exp2.baddesign;

/**
 * 创建于:2016年10月7日<br>
 * GPL 2016 a code farmer<br>
 * 模拟糖果机
 * 
 * @author infoconsole
 * @version TODO
 */
public class CandyMachine {
  // 东西卖完或者没放
  private final static int SOLD_OUT_STATE = 0;
  // 准备状态
  private final static int ON_READY_STATE = 1;
  // 有银币
  private final static int HAS_COIN_STATE = 2;
  // 正在出售
  private final static int SOLD_STATE = 3;

  private int state = SOLD_OUT_STATE;
  private int count = 0;

  public CandyMachine(int count) {
    this.count = count;
    if (count > 0) {
      state = ON_READY_STATE;
    }
  }

  public void insertCoin() {
    switch (state) {
      case SOLD_OUT_STATE:
        System.out.println("准备状态，不能放银币");
        break;
      case ON_READY_STATE:
        state = HAS_COIN_STATE;
        System.out.println("叮咚");
        break;
      case HAS_COIN_STATE:
        System.out.println("已经有银币");
        break;
      case SOLD_STATE:
        System.out.println("请等待");
        break;
    }
  }
}
