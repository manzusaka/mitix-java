package com.mitix.len.ooad.multiton.exp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Die {
  private static int maxLength;
  private static List<Die> list=null;
  
  static{
    maxLength=2;
    list=new ArrayList<Die>();
    list.add(new Die());
    list.add(new Die());
  }
  
  
  private Die(){
    
  }
  
  public static Die getInstance(int whichOne){
    if(whichOne>0 && whichOne<=maxLength){
      return list.get(whichOne-1);
    }else{
      throw new RuntimeException("illegal argument not between 0 and "+maxLength);
    }
  }
  
  public synchronized int dice(){
    Date date=new Date();
    Random r=new Random(date.getTime());
    int value=r.nextInt();
    value=Math.abs(value);
    value=value%6;
    return value+1;
  }
  
}
