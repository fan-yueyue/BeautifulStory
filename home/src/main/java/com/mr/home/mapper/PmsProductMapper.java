package com.mr.home.mapper;

import com.mr.common.dto.web.PmsProduct;
import com.mr.common.dto.web.PmsProductWithBLOBs;

import java.util.List;

public interface PmsProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductWithBLOBs record);

    int insertSelective(PmsProductWithBLOBs record);

    PmsProductWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsProductWithBLOBs record);

    int updateByPrimaryKey(PmsProduct record);

    List<PmsProductWithBLOBs> getProduct();
}