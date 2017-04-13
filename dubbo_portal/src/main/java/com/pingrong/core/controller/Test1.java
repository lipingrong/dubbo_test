package com.pingrong.core.controller;

import com.pingrong.core.bean.UserInfo;
import com.pingrong.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/12.
 */
@Controller
public class Test1 {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping(value = "/test/index")
    public String index(Model model){
        model.addAttribute("qq","oo");
        return "index";
    }
    @RequestMapping(value = "/test/addUser")
    public String haha(Model model){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("我是dubbo");
        userInfo.setAge(0);
        try {
            userInfoService.addUser(userInfo);
        model.addAttribute("qq","成功");
        } catch (Exception e) {
            e.printStackTrace();
        model.addAttribute("qq","失败");
        }
        return "index";
    }
}
