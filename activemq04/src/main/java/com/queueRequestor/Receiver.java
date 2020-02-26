package com.queueRequestor;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMessage;

import javax.jms.*;

/*
 */
public class Receiver {

    public static void main(String[] args) throws JMSException {
        //1.获取连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://node1:61616"

        );
        //2.获取一个ActiveMQ的连接
        Connection connection = factory.createConnection();
        connection.start();
        //3。获取session
        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4。获取destination,消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        //5.获取消息
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                System.out.println("receive:"+message);
                try {
                    Destination jmsReplyTo = message.getJMSReplyTo();
                    MessageProducer producer = session.createProducer(jmsReplyTo);
                    TextMessage textMessage = session.createTextMessage("replyto:已经接收到QueueRequestor消息");
                    System.out.println("j接收方-接收到消息："+textMessage);
                    producer.send(textMessage);
                    System.out.println("j接收方-发送回复消息完成");
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}




