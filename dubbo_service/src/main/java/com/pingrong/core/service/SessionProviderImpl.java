package com.pingrong.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/4/25.
 */
@Service("sessionProvider")
public class SessionProviderImpl implements SessionProvider{
    @Autowired
    private Jedis jedis;
    @Override
    public void setSession(String name, String value) throws Exception {
        jedis.set(name + ":USER_NAME",value);
        //设置过期时间S
        jedis.expire(name + ":USER_NAME",600);
    }

    @Override
    public String getSession(String name) throws Exception {
        String s = jedis.get(name + ":USER_NAME");
        if(null != s){
            jedis.expire(name + ":USER_NAME",600);
        }
        return s;
    }
}
