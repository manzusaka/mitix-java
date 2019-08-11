package com.mitix.len.jdk8base.commandforeach;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommandForEach {


    @Test
    public void forEachTest() {
        List<Email> emailList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            emailList.add(new Email(UUID.randomUUID().toString().toUpperCase(), String.valueOf("index" + i)));
        }
        emailList.forEach(new EmailSend());
    }

    @Test
    public void forEach2Test() {
        List<Email> emailList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            emailList.add(new Email(UUID.randomUUID().toString().toUpperCase(), String.valueOf("index" + i)));
        }
        emailList.forEach(email -> email.Send());
    }
}
