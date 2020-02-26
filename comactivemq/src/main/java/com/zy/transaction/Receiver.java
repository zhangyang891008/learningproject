package com.zy.transaction;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/*
消息接受
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
        Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
        //4。获取destination,消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        //5.获取消息
        MessageConsumer consumer = session.createConsumer(queue);
        for (int i = 0; i < 100; i++) {
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("message" + message.getText());
            if(i%4 == 0){
                session.commit();
            }
        }
    }
}




