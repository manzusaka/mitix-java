package com.mitix.len.jdk8base.jdk_proxy;

/**
 * @author oldflame-jm
 * @create 2018/9/5
 * ${DESCRIPTION}
 */
public class DaoImpl implements Dao {
    @Override
    public void query(String str) {
        System.out.println("做了查询动作" + str);
    }
}
