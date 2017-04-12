package com.pingrong.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/12.
 */
@Controller
public class Test1 {
    @RequestMapping(value = "/test/index")
    public String index(Model model){
        model.addAttribute("qq","oo");
        return "index";
    }
}
