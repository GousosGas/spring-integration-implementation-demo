package com.demo.integration.demointegration;

import org.springframework.messaging.Message;

public class NumericPrintService {
    public void print(Message<?> message){
        System.out.println("NumericPrintService: "+message.getPayload());
    }
}
