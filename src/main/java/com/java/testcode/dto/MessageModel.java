package com.java.testcode.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {
    private String message;

    public MessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}