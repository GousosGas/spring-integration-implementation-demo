package com.demo.integration.demointegration;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class UpperCasePrintService {
    public void print(Message<String> message){
        System.out.println(message.getPayload().toUpperCase());
    }
}
