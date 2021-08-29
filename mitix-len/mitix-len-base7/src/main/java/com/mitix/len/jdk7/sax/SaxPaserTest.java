package com.mitix.len.jdk7.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * his
 *
 * @author oldflame-jm
 * @create 2018/3/9
 * ${DESCRIPTION}
 */
public class SaxPaserTest extends DefaultHandler {

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;
    private String currentTag;
    private User user;


    public List<User> getUsers() {
        return users;
    }

    //todo 123
    /**
     * 文档解析结束后调用
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    /**
     * 节点解析结束后调用
     *
     * @param uri       : 命名空间的uri
     * @param localName : 标签的名称
     * @param qName     : 带命名空间的标签名称
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        if ("user".equals(qName)) {
            users.add(user);
            user = null;
        }
        currentTag = null;
    }

    /**
     * 文档解析开始调用
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        users = new ArrayList<User>();
    }

    /**
     * 节点解析开始调用
     *
     * @param uri       : 命名空间的uri
     * @param localName : 标签的名称
     * @param qName     : 带命名空间的标签名称
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("user".equals(qName)) {
            for (int i = 0; i < attributes.getLength(); i++) {
                user = new User();
                if ("id".equals(attributes.getLocalName(i))) {
                    user.setId(Long.parseLong(attributes.getValue(i)));
                }
            }
        }
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if ("name".equals(currentTag)) {
            user.setName(value);
        } else if ("password".equals(currentTag)) {
            user.setPassword(value);
        }
    }


    public static void main(String[] args) throws ParserConfigurationException, SAXException, URISyntaxException, IOException {

        InputStream is = SaxPaserTest.class.getClassLoader().getResourceAsStream("sax/workers.xml");
        // 1.新建一个工厂类SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.让工厂类产生一个SAX的解析类SAXParser
        SAXParser parser = factory.newSAXParser();
        // 6.将一个xml文档或者资源变成一个java可以处理的InputStream流后，解析正式开始

        SaxPaserTest saxPaserTest = new SaxPaserTest();

        parser.parse(is, saxPaserTest);

        for (int i = 0; i < saxPaserTest.getUsers().size(); i++) {
            User user = saxPaserTest.getUsers().get(i);
            System.out.println(user.toString());
        }
    }
}
