package com.mitix.len.jdk8base.commandforeach;


import java.util.function.Consumer;

public class EmailSend implements Consumer<Email> {
    @Override
    public void accept(Email email) {
        email.Send();
    }
}
