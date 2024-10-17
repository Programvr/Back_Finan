package com.Back_Finan.model;

public class Message {
    private String userMessage;
    private String botResponse;

    public Message() {}

    public Message(String userMessage, String botResponse) {
        this.userMessage = userMessage;
        this.botResponse = botResponse;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }
}
