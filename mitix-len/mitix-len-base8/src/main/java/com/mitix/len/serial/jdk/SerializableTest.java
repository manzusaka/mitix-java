package com.mitix.len.serial.jdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author oldflame-jm
 * @create 2018/11
 * @since
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        TestObject testObject = new TestObject();
        oos.writeObject(testObject);
        oos.flush();
        oos.close();

        byte[] obyte = bos.toByteArray();
        System.out.println("TestObject serial length is " + obyte.length);
        StringBuffer buffer = new StringBuffer();
        for (byte b : obyte) {
            buffer.append("$" + b);
        }
        System.out.println("TestObject serial is " + buffer.toString());

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        TestObject deTest = (TestObject) ois.readObject();
        System.out.println("restore object is " + deTest.toString());
    }


    static class TestObject extends Parent implements Serializable {

        private static final long serialVersionUID = -3186721026267206914L;

        private String className = InnerObject.class.getName();

        public int testValue = 300;

        public InnerObject innerObject = new InnerObject();

        @Override
        public String toString() {
            return "TestObject{" +
                    "className='" + className + '\'' +
                    ", testValue=" + testValue +
                    ", innerObject=" + innerObject +
                    '}';
        }
    }

    static class Parent implements Serializable {

        private static final long serialVersionUID = -4963266899668807475L;

        private String className = InnerObject.class.getName();

        public int parentValue = 100;

        @Override
        public String toString() {
            return "Parent{" +
                    "className='" + className + '\'' +
                    ", parentValue=" + parentValue +
                    '}';
        }
    }

    static class InnerObject implements Serializable {

        private static final long serialVersionUID = 5704957411985783570L;

        private String className = InnerObject.class.getName();

        public int innerValue = 200;

        @Override
        public String toString() {
            return "InnerObject{" +
                    "className='" + className + '\'' +
                    ", innerValue=" + innerValue +
                    '}';
        }
    }
}
