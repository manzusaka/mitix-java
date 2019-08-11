package com.mitix.len.jdk8base.sax;

import org.xml.sax.Locator;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class EndEvent extends SaxEvent {
    EndEvent(String namespaceURI, String localName, String qName, Locator locator) {
        super(namespaceURI, localName, qName, locator);
    }

    @Override
    public String toString() {
        return "  EndEvent(" + getQName() + ")  [" + locator.getLineNumber() + "," + locator.getColumnNumber() + "]";
    }
}
