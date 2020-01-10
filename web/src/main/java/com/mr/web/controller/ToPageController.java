package com.mr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToPageController {

    @RequestMapping("toIndex")
    public String toIndex(){
        return "view/index";
    }
}
