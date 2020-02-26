package deadletter;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/*
    发送持久化的queue消息，并设置超时时间为1秒；
    当消费者消费数据的时候，MQ会检查超时时间，如果已经是过期的消息，会将消息放入死信队列
    （默认情况下放入死信队列消息是持久化的过期消息，如果想要放入非持久化的消息需要配置，超时消息不放入死信队列也需要特殊设置，topic消息要放入死信队列也需要设置）
    死信队列可以有多个，如果不自定个Desitination对应的死信队列，将放入默认的死信队列中
 */
public class DLSender {

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
        MessageProducer producer = session.createProducer(queue);
            //5.2.创建消息
        TextMessage textMessage = session.createTextMessage("测试消息：持久化消息过期是否存入死信队列");
            // 5。3向destination 写入消息
        producer.setTimeToLive(5000);
        //producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); //设置超时时间为一秒，默认是持久化消息
        producer.send(textMessage);
        //6.关闭连接
        connection.close();
        System.out.println("system exit");
    }
}
