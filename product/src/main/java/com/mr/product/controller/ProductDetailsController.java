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

    @ResponseBody
    @RequestMapping("productDetailsInquiry")
    public PmsProductVO productDetailsInquiry(PmsProductVO pmsProductVO){
        System.out.println(pmsProductVO.getId());
        PmsProductVO pmsProduct = productDetailsSer.productDetailsSer(pmsProductVO);
        System.out.println("111");
        return pmsProduct;
    }


}
