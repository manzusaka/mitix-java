package com.mitix.len.jdk8base.sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class MySaxHandler extends DefaultHandler {


    public List<SaxEvent> saxEventList = new ArrayList<SaxEvent>();
    LinkedList<String> elementStack = new LinkedList<>();
    Locator locator;

    /**
     * 解析外部实体.
     *
     * @see org.xml.sax.EntityResolver
     * @see org.xml.sax.DTDHandler
     * @see org.xml.sax.ContentHandler
     * @see org.xml.sax.ErrorHandler
     */
    @Override
    public InputSource resolveEntity(String publicId, String systemId)
            throws IOException, SAXException {
        System.out.println("method is {resolveEntity} and publicId ={" + publicId + "} and systemId ={" + systemId + "}");
        return null;
    }

    /**
     * Receive notification of a notation declaration.
     * 接收符号声明的通知
     *
     * @see org.xml.sax.DTDHandler#notationDecl
     */
    @Override
    public void notationDecl(String name, String publicId, String systemId)
            throws SAXException {
        System.out.println("method is {notationDecl} and publicId ={" + publicId + "} and systemId ={" + systemId + "}");
    }


    /**
     * Receive notification of an unparsed entity declaration.
     * 接收未解析实体声明的通知。
     *
     * @see org.xml.sax.DTDHandler#unparsedEntityDecl
     */
    @Override
    public void unparsedEntityDecl(String name, String publicId,
                                   String systemId, String notationName)
            throws SAXException {
        System.out.println("method is {unparsedEntityDecl} and publicId ={" + publicId + "} and systemId ={" + systemId + "}");
    }


    /**
     * Receive a Locator object for document events.
     * 接收用于文档事件的Locator对象
     *
     * @see org.xml.sax.ContentHandler#setDocumentLocator
     * @see Locator
     */
    @Override
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
        System.out.println("method is {setDocumentLocator} and locator ={" + locator + "}");
    }


    /**
     * Receive notification of the beginning of the document.
     * 收到文件开头的通知
     *
     * @see org.xml.sax.ContentHandler#startDocument
     */
    @Override
    public void startDocument()
            throws SAXException {
        System.out.println("method is {startDocument}");

    }


    /**
     * Receive notification of the end of the document.
     * 收到文件结尾的通知
     *
     * @see org.xml.sax.ContentHandler#endDocument
     */
    @Override
    public void endDocument()
            throws SAXException {
        System.out.println("method is {endDocument}");

    }


    /**
     * Receive notification of the start of a Namespace mapping.
     * 接收名称空间映射开始的通知
     *
     * @see org.xml.sax.ContentHandler#startPrefixMapping
     */
    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        System.out.println("method is {startPrefixMapping} and prefix ={" + prefix + "} and uri ={" + uri + "}");
    }


    /**
     * Receive notification of the end of a Namespace mapping.
     * 接收名称空间映射结束的通知
     *
     * @see org.xml.sax.ContentHandler#endPrefixMapping
     */
    @Override
    public void endPrefixMapping(String prefix)
            throws SAXException {
        System.out.println("method is {endPrefixMapping} and prefix ={" + prefix + "}");
    }


    /**
     * Receive notification of the start of an element.
     * 接收元素开始的通知
     *
     * @see org.xml.sax.ContentHandler#startElement
     */
    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        String tagName = qName;
        elementStack.push(tagName);
        saxEventList.add(new StartEvent((LinkedList<String>) elementStack.clone(), namespaceURI, localName, tagName, attributes, getLocator()));
    }


    /**
     * Receive notification of the end of an element.
     * 接收元素结束的通知
     *
     * @see org.xml.sax.ContentHandler#endElement
     */
    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        saxEventList.add(new EndEvent(namespaceURI, localName, qName, getLocator()));
        elementStack.pop();
        System.out.println("method is {endElement} and uri ={" + namespaceURI + "} and localName ={" + localName + "} and qName ={" + qName + "}");
    }


    /**
     * Receive notification of character data inside an element.
     * 接收元素中字符数据的通知
     *
     * @see org.xml.sax.ContentHandler#characters
     */
    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {
        String bodyStr = new String(ch, start, length);
        //获取上一个解析的Event  如果上一个还是BodyEvent  那就是把内容拼进去
        SaxEvent lastEvent = getLastEvent();
        if (lastEvent instanceof BodyEvent) {
            BodyEvent be = (BodyEvent) lastEvent;
            be.append(bodyStr);
        } else {
            // ignore space only text if the previous event is not a BodyEvent
            if (!isSpaceOnly(bodyStr)) {
                saxEventList.add(new BodyEvent(bodyStr, getLocator()));
            }
        }
        System.out.println("method is {characters} and bodyStr ={" + bodyStr + "}");
    }

    private boolean isSpaceOnly(String bodyStr) {
        String bodyTrimmed = bodyStr.trim();
        return (bodyTrimmed.length() == 0);
    }

    private SaxEvent getLastEvent() {
        if (saxEventList.isEmpty()) {
            return null;
        }
        int size = saxEventList.size();
        return saxEventList.get(size - 1);
    }


    /**
     * Receive notification of ignorable whitespace in element content.
     * 接收元素内容中可忽略空格的通知
     *
     * @see org.xml.sax.ContentHandler#ignorableWhitespace
     */
    @Override
    public void ignorableWhitespace(char ch[], int start, int length)
            throws SAXException {
        System.out.println("method is {ignorableWhitespace} and chStr ={" + new String(ch, start, length) + "}");

    }


    /**
     * Receive notification of a processing instruction.
     * 接收处理指令的通知
     *
     * @see org.xml.sax.ContentHandler#processingInstruction
     */
    @Override
    public void processingInstruction(String target, String data)
            throws SAXException {
        System.out.println("method is {processingInstruction} and target ={" + target + "} and data ={" + data + "}");
    }


    /**
     * Receive notification of a skipped entity.
     * 接收跳过实体的通知
     *
     * @see org.xml.sax.ContentHandler#processingInstruction
     */
    @Override
    public void skippedEntity(String name)
            throws SAXException {
        System.out.println("method is {skippedEntity} and name ={" + name + "}");
    }

    /**
     * Receive notification of a parser warning.
     * 接收解析器警告的通知
     *
     * @see org.xml.sax.ErrorHandler#warning
     * @see SAXParseException
     */
    @Override
    public void warning(SAXParseException e)
            throws SAXException {
        System.out.println("method is {warning} and e ={" + e.getMessage() + "}");

    }


    /**
     * Receive notification of a recoverable parser error.
     * 接收可恢复解析器错误的通知
     *
     * @see org.xml.sax.ErrorHandler#warning
     * @see SAXParseException
     */
    @Override
    public void error(SAXParseException e)
            throws SAXException {
        System.out.println("method is {error} and e ={" + e.getMessage() + "}");
    }


    /**
     * Report a fatal XML parsing error.
     * 报告一个致命的XML解析错误
     *
     * @see org.xml.sax.ErrorHandler#fatalError
     * @see SAXParseException
     */
    @Override
    public void fatalError(SAXParseException e)
            throws SAXException {
        System.out.println("method is {fatalError} and e ={" + e.getMessage() + "}");
        throw e;
    }

    public Locator getLocator() {
        return locator;
    }

    public List<SaxEvent> getSaxEventList() {
        return saxEventList;
    }
}
