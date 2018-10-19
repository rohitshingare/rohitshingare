package com.example.dell.dishservices;

import java.util.Date;

/**
 * Created by DELL on 26-04-2018.
 */

public class ChatMessage {
    private String messagetxt;
    private String messageUser;
    private long messageTime;

    public ChatMessage(String messagetxt, String messageUser) {
        this.messagetxt = messagetxt;
        this.messageUser = messageUser;
        messageTime = new Date().getTime();
    }

    public ChatMessage() {
    }

    public String getMessagetxt() {
        return messagetxt;
    }

    public void setMessagetxt(String messagetxt) {
        this.messagetxt = messagetxt;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
