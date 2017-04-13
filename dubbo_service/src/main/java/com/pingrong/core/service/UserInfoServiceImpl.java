package com.pingrong.core.service;

import com.pingrong.core.bean.UserInfo;
import com.pingrong.core.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/12.
 */
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public void addUser(UserInfo user) throws Exception {
        userInfoMapper.insert(user);
        int[] ints = new int[]{1,2};
        //System.out.println(ints[3]);

    }
}
