package com.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class Producer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("zy-producer01");
        producer.setNamesrvAddr("node1:9876");
        producer.start();

        Message msg = new Message("topic01", "hello".getBytes());
        SendResult result = producer.send(msg);
        System.out.println("生产者收到消息确认："+result);
        producer.shutdown();
    }
}
