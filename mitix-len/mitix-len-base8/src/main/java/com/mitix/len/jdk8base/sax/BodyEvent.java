package com.mitix.len.jdk8base.sax;

import org.xml.sax.Locator;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class BodyEvent extends SaxEvent {
    private String text;

    BodyEvent(String text, Locator locator) {
        super(null, null, null, locator);
        this.text = text;
    }

    /**
     * Always trim trailing spaces from the body text.
     *
     * @return
     */
    public String getText() {
        if (text != null) {
            return text.trim();
        }
        return text;
    }

    @Override
    public String toString() {
        return "BodyEvent(" + getText() + ")" + locator.getLineNumber() + "," + locator.getColumnNumber();
    }

    public void append(String str) {
        text += str;
    }
}
