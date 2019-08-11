package com.mitix.len.inttver.jms;

/**
 * @author oldflame-jm
 * @create 2017/12/22
 * ${DESCRIPTION}
 */
public class Chat /*implements MessageListener*/ {
//    private TopicConnection connection;
//    private TopicSession pubSession;
//    private TopicPublisher publisher;
//    private String userName;
//
//    public Chat(String topicFactory, String topicName, String userName) throws NamingException, JMSException {
//
//        //jndi链接jndi.properties
//        InitialContext context = new InitialContext();
//        //jms链接工厂
//        TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup(topicFactory);
//        TopicConnection connection = factory.createTopicConnection();
//        //jms回话对象
//        TopicSession pubSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
//        TopicSession subSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
//        //jms主题
//        Topic chatTopic = (Topic) context.lookup(topicName);
//        //创建jms发布者  订阅者
//        TopicPublisher publisher = pubSession.createPublisher(chatTopic);
//        //选择器null和noLocal标记为true  标明发布者生产的消息不应该被他自己所消费
//        TopicSubscriber subscriber = subSession.createSubscriber(chatTopic, null, true);
//        //设置监听器
//        subscriber.setMessageListener(this);
//        this.connection = connection;
//        this.publisher = publisher;
//        this.pubSession = pubSession;
//        this.userName = userName;
//        //启动
//        connection.start();
//
//    }
//
//    @Override
//    public void onMessage(Message message) {
//        TextMessage textMessage = (TextMessage) message;
//        System.out.println(textMessage);
//
//    }
//
//    protected void writeMessage(String text) throws JMSException {
//        TextMessage textMessage = pubSession.createTextMessage();
//        textMessage.setText(userName + " :" + text);
//        publisher.publish(textMessage);
//
//    }
//
//    public void close() throws JMSException {
//        this.connection.close();
//    }
//
//    public static void main(String[] args) {
//
//    }
}
