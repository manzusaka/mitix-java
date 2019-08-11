package com.mitix.len.ooad.design.exp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 孩子模拟类
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Child implements Runnable {
  private static final Logger logger = LoggerFactory.getLogger(Child.class);
  private boolean wakeUp = false;

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    try {
      Thread.sleep(5000);
      setWakeUp(true);
    } catch (InterruptedException e) {
      logger.error("child wakeup failed", e);
    }
  }


  public boolean getWakeUp() {
    return wakeUp;
  }
  

  private void setWakeUp(boolean wakeUp) {
    if (logger.isDebugEnabled()) {
      logger.debug("wakeup is set=" + wakeUp);
    }
    this.wakeUp = wakeUp;
  }

}
