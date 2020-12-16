package com.demo.integration.demointegration;

import org.springframework.messaging.Message;

public class DefaultService {
    public void print(Message<?> message){
        System.out.println("from default service" +message.getPayload());
    }
}
