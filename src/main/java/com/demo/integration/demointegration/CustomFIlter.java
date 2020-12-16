package com.demo.integration.demointegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.Collection;

public class CustomFIlter implements MessageSelector {

    @Override
    public boolean accept(Message<?> message) {
        return message.getPayload().equals(7);
    }
}
