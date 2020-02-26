package com.delay;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

/*
    消息延迟投递
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
       connection.start();
        //3。获取session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //4。获取destination,消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        //创建消息
        TextMessage textMessage = session.createTextMessage("测试消息:延迟消息");
        //设置延迟10秒钟发送
        textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,10*1000);
        // 5.3向destination 写入消息
        MessageProducer producer = session.createProducer(queue);
        producer.send(textMessage);
        //6.关闭连接
        connection.close();
        System.out.println("system exit");
    }
}
