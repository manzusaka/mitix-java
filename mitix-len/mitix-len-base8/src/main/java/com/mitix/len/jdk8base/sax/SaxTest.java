package com.mitix.len.jdk8base.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/9/21
 * ${DESCRIPTION}
 */
public class SaxTest {


    public static void main(String[] args) {
        try {
            // 创建一个解析XML的工厂对象
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            MySaxHandler handler = new MySaxHandler();
            parser.parse(new FileInputStream("/Users/oldflame-jm/githubProjects/mitix/mitix-len/mitix-len-base8/target/classes/person.xml"), handler);
            List<SaxEvent> saxEvents = handler.getSaxEventList();
            for (SaxEvent saxEvent : saxEvents) {
                System.out.println(saxEvent.toString());
            }
            //parser.parse(new FileInputStream("/Users/oldflame-jm/githubProjects/mitix/mitix-len/mitix-len-base8/target/classes/applicationContext.xml"), handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
