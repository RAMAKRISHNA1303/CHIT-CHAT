package com.example.chitchat;

public class MessageModel {
    public static final int USER_MESSAGE = 1;
    public static final int BOT_MESSAGE = 2;

    private int type;
    private String content;

    public MessageModel(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
