package com.mitix.len.jdk8base.inner_class_test;

/**
 * @author oldflame-jm
 * @create 2018/11
 * @since
 */
public class Father {

    private String fatherField;

    private void fatherHello() {
        System.out.println("father hello");
    }


    public class Child {

        private String childField;

        private void sayHello() {
            System.out.println("hello child");
        }
    }

    public String getFatherField() {
        return fatherField;
    }

    public void setFatherField(String fatherField) {
        this.fatherField = fatherField;
    }
}
