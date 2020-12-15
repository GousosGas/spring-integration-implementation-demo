package com.demo.integration.demointegration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

public class PrintService {
    public Message<String> print(Message<String> message){
        return MessageBuilder
                .withPayload("New message with payload:"+message.getPayload())
                .build();
    }
}
