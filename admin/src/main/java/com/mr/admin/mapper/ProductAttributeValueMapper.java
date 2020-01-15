package com.mr.admin.mapper;

import com.mr.admin.entity.ProductAttributeValue;

import java.util.List;

public interface ProductAttributeValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductAttributeValue record);

    int insertSelective(ProductAttributeValue record);

    ProductAttributeValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductAttributeValue record);

    int updateByPrimaryKey(ProductAttributeValue record);

    List<ProductAttributeValue> selectList(Long id);
}