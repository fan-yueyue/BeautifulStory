package com.mr.product.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2020/1/10.
 */
@Controller
@RequestMapping("test")
public class TestController {




    @ResponseBody
    @RequestMapping("test1")
    public String test1(){
        System.out.println("111111");
        return "wwwww";
    }



}
