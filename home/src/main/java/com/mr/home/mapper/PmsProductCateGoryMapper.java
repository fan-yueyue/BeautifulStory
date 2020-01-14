package com.mr.home.mapper;

import com.mr.common.dto.web.PmsProductCateGory;

import java.util.List;

public interface PmsProductCateGoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCateGory record);

    int insertSelective(PmsProductCateGory record);

    PmsProductCateGory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductCateGory record);

    int updateByPrimaryKeyWithBLOBs(PmsProductCateGory record);

    int updateByPrimaryKey(PmsProductCateGory record);

    List<PmsProductCateGory> getBrandById();
}