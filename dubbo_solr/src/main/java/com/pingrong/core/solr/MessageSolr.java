package com.pingrong.core.solr;

import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * MQ监听处理类
 */
public class MessageSolr implements MessageListener{
    /**
     * 处理接收到的消息
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage mqTextMessage = (ActiveMQTextMessage) message;
        try {
            System.out.println(mqTextMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
