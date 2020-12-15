package com.demo.integration.demointegration;

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

/**
 * Gateway will pick the message and forward it
 * to the channel (inputChannel - queue channel)
 * The Channel will deliver to the
 * service activator which will call the printService
 */
public interface PrinterGateway {
    public Future<Message<String>> print(Message<?> message);
}
