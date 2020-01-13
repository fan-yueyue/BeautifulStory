package com.mr.home.mapper;

import com.mr.common.dto.web.PmsBrand;

import java.util.List;

public interface PmsBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    List<PmsBrand> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);

    List<PmsBrand> selectList();
}