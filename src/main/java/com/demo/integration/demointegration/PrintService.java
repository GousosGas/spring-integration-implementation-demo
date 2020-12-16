package com.demo.integration.demointegration;

import org.springframework.messaging.Message;

public class PrintService {
    public void print(Message<?> message){
        System.out.println("in string payload" +message.getPayload());
    }
}
