package com.mitix.len.jdk8base.sax;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;

import java.util.LinkedList;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class StartEvent extends SaxEvent {
    final private AttributesLocal als;
    //当前的解析队列
    final private LinkedList<String> snapshoot;

    StartEvent(LinkedList<String> snapshoot, String namespaceURI, String localName, String qName, Attributes attributes, Locator locator) {
        super(namespaceURI, localName, qName, locator);
        // locator impl is used to take a snapshot!
        this.als = new AttributesLocalImpl(attributes);
        this.snapshoot = snapshoot;
    }

    public AttributesLocal getAttributes() {
        return als;
    }

    public LinkedList<String> getCurrent() {
        return snapshoot;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("StartEvent(");
        b.append("qName [" + getQName() + "] ");
        //b.append(snapshoot.toString());
        if (als != null) {
            for (int i = 0; i < als.getLength(); i++) {
                if (i > 0) {
                    b.append(' ');
                }
                b.append(als.getQName(i)).append("=[").append(als.getValue(i)).append("] ");
            }
        }
        b.append(")  [");
        b.append(locator.getLineNumber());
        b.append(",");
        b.append(locator.getColumnNumber());
        b.append("]");
        return b.toString();
    }
}
