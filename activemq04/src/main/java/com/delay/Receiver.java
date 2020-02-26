package com.delay;

import org.apache.activemq.ActiveMQConnectionFactory;

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
                System.out.println("接收方："+message);
            }
        });
    }
}




