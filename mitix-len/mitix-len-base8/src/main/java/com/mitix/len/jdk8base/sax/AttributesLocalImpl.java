package com.mitix.len.jdk8base.sax;

import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class AttributesLocalImpl implements AttributesLocal {
    private List<String> keys = new ArrayList<>();
    private Properties attrs = new Properties();

    public AttributesLocalImpl(Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            keys.add(attributes.getQName(i));
            attrs.setProperty(attributes.getQName(i), attributes.getValue(i));
        }
    }

    @Override
    public int getLength() {
        return attrs.size();
    }

    @Override
    public String getQName(int index) {
        return keys.get(index);
    }

    @Override
    public String getValue(int index) {
        String key = keys.get(index);
        return attrs.getProperty(key);
    }

    @Override
    public String getValue(String qName) {
        return attrs.getProperty(qName);
    }
}
