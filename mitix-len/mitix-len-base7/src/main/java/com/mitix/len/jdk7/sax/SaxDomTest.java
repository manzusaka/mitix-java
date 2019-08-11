package com.mitix.len.jdk7.sax;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author oldflame-jm
 * @create 2018/3/14
 * ${DESCRIPTION}
 */
public class SaxDomTest {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        InputStream is = SaxPaserTest.class.getClassLoader().getResourceAsStream("sax/workers.xml");
        InputSource inputSource = new InputSource(is);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document document = docBuilder.parse(inputSource);
        Element root = document.getDocumentElement();
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Text) {
                Text text = (Text) node;
                System.out.println(text);
            }
            if (node instanceof Element) {
                System.out.println(node.getNamespaceURI());
            }

        }
    }
}
