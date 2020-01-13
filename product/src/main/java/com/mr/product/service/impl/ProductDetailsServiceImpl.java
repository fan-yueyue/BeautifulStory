package com.mr.product.service.impl;

import com.mr.product.entity.PmsProductVO;
import com.mr.product.mapper.ProductDetailsMapper;
import com.mr.product.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2020/1/10.
 */
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsMapper productDetailsMapper;


    @Override
    public PmsProductVO productDetailsSer() {
        PmsProductVO pmsProductVO = productDetailsMapper.productDetailsSer();
        return pmsProductVO;
    }



}
