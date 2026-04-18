package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {

    private MessageType messageType;
    private String detail;

    public ErrorMessage(MessageType messageType, String detail) {
        this.messageType = messageType;
        this.detail = detail;
    }

    public String prepareMessage() {
        StringBuilder sb = new StringBuilder();

        sb.append(messageType.getMessage());

        if (detail != null) {
            sb.append(" : ").append(detail);
        }

        return sb.toString();
    }
}