package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String ofStatic;

    public ErrorMessage(MessageType messageType, MessageType messageType1) {
    }

    public String preapareMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageType.getMessage());
        if (ofStatic != null) {
            stringBuilder.append(" : ").append(ofStatic);
        }
        return stringBuilder.toString();
    }
}
