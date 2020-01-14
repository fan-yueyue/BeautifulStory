package com.mr.cart.mapper;


import com.mr.common.vo.OmsCartItemVO;
import com.mr.common.vo.PmsProductVO;

import java.util.List;

public interface OmsCartItemEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCartItemVO record);

    int insertSelective(PmsProductVO record);

    OmsCartItemVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsCartItemVO record);

    int updateByPrimaryKey(OmsCartItemVO record);

    List<OmsCartItemVO> getCartInfo(OmsCartItemVO cartVO);


}