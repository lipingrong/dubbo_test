package com.pingrong.core.service;

/**
 * Created by Administrator on 2017/4/25.
 */
public interface SessionProvider {
    /**
     * 设置
     * @param name
     * @param value
     * @throws Exception
     */
    public void setSession(String name,String value)throws Exception;

    /**
     * 获取
     * @param name
     * @return
     * @throws Exception
     */
    public String getSession(String name)throws Exception;
}
