package com.mitix.len.ooad.design.exp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 父亲模拟类
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Dad implements Runnable {
  private static final Logger logger = LoggerFactory.getLogger(Dad.class);
  private Child child;

  public Dad(Child child) {
    this.child = child;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  public void run() {
    while (!child.getWakeUp()) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        logger.error("look up failed", e);
      }
    }
    feed(child);
  }

  private void feed(Child child2) {
    if(logger.isInfoEnabled()){
      logger.info("feed child");
    }
  }

}
