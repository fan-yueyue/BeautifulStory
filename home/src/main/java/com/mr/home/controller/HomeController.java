package com.mr.home.controller;

import com.mr.common.result.ResultVO;
import com.mr.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private HomeService homeService;


    @RequestMapping("getCarousel")
    public ResultVO getCarousel(){
        ResultVO resultVO=homeService.getCarousel();
        return resultVO;
    }
    @RequestMapping("getBrand")
    public ResultVO getBrand(String brandId){
        ResultVO r=homeService.getBrand();
    return r;
    }

    @RequestMapping("getProductByBrandId")
    public ResultVO getProductByBrandId(){
       ResultVO l= homeService.getProductByBrandId();
        return l;
    }
}
