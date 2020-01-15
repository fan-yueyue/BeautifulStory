package com.mr.admin.controller;

import com.mr.admin.service.ProductAttributeValueService;
import com.mr.common.result.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductAttributeValueController
 * @Description: TODO
 * @Author fantueyue
 * @Date 2020/1/15
 * @Version V1.0
 **/
@RequestMapping("productAttributeValue")
@RestController
public class ProductAttributeValueController {
    @Autowired
    private ProductAttributeValueService productAttributeValueService;

    @GetMapping("selectList")
    public ResultVO selectList(Long id){
        id=1L;
        return productAttributeValueService.selectList(id);
    }
}
