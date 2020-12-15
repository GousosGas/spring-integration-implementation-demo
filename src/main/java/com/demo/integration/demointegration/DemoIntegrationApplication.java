package com.demo.integration.demointegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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

        List<Future<Message<String>>> futureList =
                new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Message<String> message=
                    MessageBuilder
                            .withPayload("Printing message payload for " +i)
                            .setHeader("messageNum", i)
                    .build();
            System.out.println("Sending message "+ i);
            futureList.add(this.printerGateway.print(message));
        }

        for (Future<Message<String>> future: futureList
             )
            System.out.println(future.get().getPayload());

    }
}
