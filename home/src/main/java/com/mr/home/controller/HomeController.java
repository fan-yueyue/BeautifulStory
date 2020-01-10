package com.mr.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("home")
@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping("test")
    public Byte test(){
        return 111;
    }
}
