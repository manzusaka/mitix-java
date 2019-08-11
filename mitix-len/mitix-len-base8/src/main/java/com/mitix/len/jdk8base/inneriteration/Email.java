package com.mitix.len.jdk8base.inneriteration;

public class Email {
    private String address;
    private String name;

    public Email(String address, String name) {
        this.address = address;
        this.name = name;
    }


    public void Send() {
        System.out.println("email is send by name=" + name + "--address=" + address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
