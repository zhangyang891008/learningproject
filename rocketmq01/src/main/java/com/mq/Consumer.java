package com.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/*
rocketmq
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("zy-consumer");
        consumer.setNamesrvAddr("node1:9876");
        //设置监听的topic和过滤机制
        consumer.subscribe("topic01","*");
        consumer.registerMessageListener(new MessageListenerOrderly() {
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                try{
                    for (MessageExt messageExt : list) {
                        System.out.println(messageExt);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    return ConsumeOrderlyStatus.ROLLBACK;
                }
                System.out.println("消费成功");
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
    }
}
