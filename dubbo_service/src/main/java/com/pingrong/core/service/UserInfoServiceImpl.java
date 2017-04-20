package com.pingrong.core.service;

import com.pingrong.core.bean.UserInfo;
import com.pingrong.core.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/12.
 */
@SuppressWarnings("Convert2Lambda")
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;
    //MQ
    @Autowired
    private JmsTemplate jmsTemplate;
    @Override
    public void addUser(UserInfo user) throws Exception {
        user.setName("测试solr");
        user.setAge(0);
        userInfoMapper.insert(user);
        //发送MQ消息
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("solr消息传递");
            }
        });
    }
}
