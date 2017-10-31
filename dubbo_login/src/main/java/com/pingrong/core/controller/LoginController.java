package com.pingrong.core.controller;

import com.pingrong.core.common.RequestUtils;
import com.pingrong.core.service.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
public class LoginController {
    @Autowired
    private SessionProvider sessionProvider;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response){
        try {
            //获取request中的cookie内容
            String csessionid = RequestUtils.getCSESSIONID(request, response);
            //保存到redis
            sessionProvider.setSession(csessionid,"shide");
            //获取登录信息
            String woshiyonghu = sessionProvider.getSession(csessionid);
            System.out.println(woshiyonghu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String name,String pwd){
        System.out.println(name+pwd+"成功！！！！！！！！！！！！！");
        return "index";
    }
}
