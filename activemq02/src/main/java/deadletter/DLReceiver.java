package deadletter;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/*
    接收消息，如果超过TTL的时间就接受不到了
 */
public class DLReceiver {

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
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4。获取destination,消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        //5.获取消息
        MessageConsumer consumer = session.createConsumer(queue);
        while(true){
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("message" + message.getText());
        }
    }
}




