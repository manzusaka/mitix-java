package com.mitix.len.jdk8base.inneriteration;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 内部迭代
 */
public class ConllectionForEach {


    @Test
    public void forEachTest() {
        List<Email> emailList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            emailList.add(new Email(UUID.randomUUID().toString().toUpperCase(), String.valueOf("index" + i)));
        }
        emailList.forEach(email -> email.Send());
    }

}
