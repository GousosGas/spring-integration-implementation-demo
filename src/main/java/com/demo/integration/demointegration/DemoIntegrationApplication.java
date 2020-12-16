package com.demo.integration.demointegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("classpath:integration-context.xml")
public class DemoIntegrationApplication implements ApplicationRunner {

    @Autowired
    private  PrinterGateway printerGateway;

    public static void main(String[] args) {
        SpringApplication.run(DemoIntegrationApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Message<?> message =
                    MessageBuilder
                            .withPayload("hey"+i)
                            .setHeader("routeHeader","string")
                            .build();
            this.printerGateway.print(message);
        }
    }
}
