package com.mq.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class ActiveMQService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String destination, String msg){
        System.out.println("send...");

        jmsMessagingTemplate.convertAndSend( destination, msg);
    }
}
