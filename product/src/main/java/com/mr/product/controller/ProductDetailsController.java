package com.mr.product.controller;

import com.mr.product.entity.PmsProductVO;
import com.mr.product.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2020/1/10.
 */
@Controller
@RequestMapping("productDetails")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsSer;

    //商品详情展示方法
    @ResponseBody
    @RequestMapping("productDetailsInquiry")
    public PmsProductVO productDetailsInquiry(PmsProductVO pmsProductVO){
        PmsProductVO pmsProduct = productDetailsSer.productDetailsSer(pmsProductVO);
        return pmsProduct;
    }
    @ResponseBody
    @RequestMapping("testaa")
    public PmsProductVO testaa(PmsProductVO pmsProductVO,String quantity){
        System.out.println(pmsProductVO);
        return pmsProductVO;
    }
    @ResponseBody
    @RequestMapping("test2")
    public PmsProductVO test2(PmsProductVO pmsProductVO,String quantity){
        System.out.println(pmsProductVO.getId());
        return pmsProductVO;
    }



}
