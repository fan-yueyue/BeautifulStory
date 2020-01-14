package com.mr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("web")
public class ToPageController {

    @RequestMapping("toIndex")
    public String toIndex(){
        return "view/index";
    }

    @RequestMapping("toMycart")
    public String toMycart(){
        return "view/mycart";
    }





    @RequestMapping("toShopdetail")
    public String toShopdetail(){
        return "view/shopdetail";
    }



    @RequestMapping("toBrandStreet")
    public String toBrandStreet(Model model){
        return "view/brandstreet";
    }

    @RequestMapping("toOrder")
    public String toOrder(){
        return "orderlist";
    }

    @RequestMapping("toAddress")
    public String toAddress(){
        return "address";
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
