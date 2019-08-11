package com.mitix.len.jdk8base.sax;

import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class SaxEvent {
    final public String namespaceURI;
    final public String localName;
    final public String qName;
    final public Locator locator;

    SaxEvent(String namespaceURI, String localName, String qName, Locator locator) {
        this.namespaceURI = namespaceURI;
        this.localName = localName;
        this.qName = qName;
        // locator impl is used to take a snapshot!
        this.locator = new LocatorImpl(locator);
    }

    public String getLocalName() {
        return localName;
    }

    public Locator getLocator() {
        return locator;
    }

    public String getNamespaceURI() {
        return namespaceURI;
    }

    public String getQName() {
        return qName;
    }
}
