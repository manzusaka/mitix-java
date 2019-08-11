package com.mitix.len.jdk8base.sax;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public interface AttributesLocal {

    int getLength();

    String getQName(int index);

    String getValue(int index);

    String getValue(String qName);
}
