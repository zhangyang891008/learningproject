package com.queueRequestor;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/*
QueueRequestor同步消息
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
       ActiveMQConnection connection = (ActiveMQConnection) factory.createConnection();
       connection.start();
        //3。获取session
        QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);

        //4。获取destination,消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        //创建消息
        TextMessage textMessage = session.createTextMessage("测试消息:发送QueueRequestor消息");
            // 5。3向destination 写入消息
        QueueRequestor requestor = new QueueRequestor(session,queue);
        //发送同步请求，并且阻塞的接收接收方回复的消息
        System.out.println("发送方开始发送");
        Message requestMsg = requestor.request(textMessage);
        System.out.println("发送方-接收到回复消息："+requestMsg);
        //6.关闭连接
        connection.close();
        System.out.println("system exit");
    }
}
