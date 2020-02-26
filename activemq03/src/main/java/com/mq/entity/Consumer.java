package com.mq.entity;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "spring-boot")
    public void receiveQueue(String text) {
        System.out.println(text);
    }

    @JmsListener(destination = "spring-boot")
    public void receiveQueue2(Message msg) {
        System.out.println(msg.toString());
    }
}