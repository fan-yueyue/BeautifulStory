package com.mr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("web")
public class ToPageController {

    //index页面
    @RequestMapping("toIndex")
    public String toIndex(){
        return "view/index";
    }

    @RequestMapping("toBrandStreet")
    public String toBrandStreet(Model model){
        return "view/brandstreet";
    }

    //我的订单
    @RequestMapping("toOrder")
    public String toOrder(){
        return "orderlist";
    }

    //地址管理
    @RequestMapping("toAddress")
    public String toAddress(){
        return "address";
    }

    //我的足迹
    @RequestMapping("toFootprint")
    public String toFootprint(){
        return "footprint";
    }


    @RequestMapping("toWeb")
    public  ModelAndView toWeb(String url){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(url);
        return modelAndView;
    }

    @RequestMapping("toSelectDetail")
    public  ModelAndView toSelectDetail(String url,Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/shopdetail");
        modelAndView.addObject("name",id);
        return modelAndView;
    }
}
