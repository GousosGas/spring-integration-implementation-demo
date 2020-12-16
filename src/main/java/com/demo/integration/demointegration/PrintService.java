package com.demo.integration.demointegration;

import org.springframework.messaging.Message;

public class PrintService {
    public void print(Message<?> message){
        System.out.println("PrintService: " +message.getPayload());
    }
}
