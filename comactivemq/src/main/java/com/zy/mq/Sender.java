package com.zy.mq;

import jdk.nashorn.internal.ir.CallNode;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/*
消息发送
 */
public class Sender {

    public static void main(String[] args) throws JMSException {
        //1.获取连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://node1:61616"
        );
        //2.获取一个ActiveMQ的连接
        Connection connection = factory.createConnection();
        //3。获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4。获取destination,消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        //5.1 消息创建者
        //consumer ->消费者
        //producer ->创建者
        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 100; i++) {
            //5.2.创建消息
            TextMessage textMessage = session.createTextMessage("hi" + i);
            // 5。3向destination 写入消息
            producer.send(textMessage);
        }
        //6.关闭连接
        connection.close();
        System.out.println("system exit");
    }
}
