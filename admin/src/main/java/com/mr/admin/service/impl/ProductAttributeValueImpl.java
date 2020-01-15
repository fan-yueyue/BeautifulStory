package com.mr.admin.service.impl;

import com.mr.admin.entity.ProductAttributeValue;
import com.mr.admin.mapper.ProductAttributeValueMapper;
import com.mr.admin.service.ProductAttributeValueService;
import com.mr.common.result.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProductAttributeValueImpl
 * @Description: TODO
 * @Author fantueyue
 * @Date 2020/1/15
 * @Version V1.0
 **/
@Service
public class ProductAttributeValueImpl implements ProductAttributeValueService {
    @Resource
    private ProductAttributeValueMapper productAttributeValueMapper;

    @Override
    public ResultVO selectList(Long id) {
        ResultVO resultVO = new ResultVO();
     List<ProductAttributeValue> list= productAttributeValueMapper.selectList(id);
        resultVO.setDataList(list);
        return resultVO;
    }
}
