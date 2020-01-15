package com.mr.web.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("orderController")
public class OrderController {

    @GetMapping("order")
    public String order() {
        return "orderlist";
    }

    @GetMapping("comment")
    public ModelAndView comment(Long id,ModelMap map) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("commment");
        return modelAndView;
    }

    @GetMapping("comment2")
    public ModelAndView comment2(Long id,ModelMap map) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("commmentupdate");
        return modelAndView;
    }




}
