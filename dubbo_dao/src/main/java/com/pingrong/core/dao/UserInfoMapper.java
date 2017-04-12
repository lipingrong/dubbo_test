package com.pingrong.core.dao;

import com.pingrong.core.bean.UserInfo;

/**
 * Created by Administrator on 2017/4/11.
 */
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}
