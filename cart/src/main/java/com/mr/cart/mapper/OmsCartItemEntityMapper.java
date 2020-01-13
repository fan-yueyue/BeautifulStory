package com.mr.cart.mapper;


import com.mr.cart.vo.OmsCartItemVO;

import java.util.List;

public interface OmsCartItemEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCartItemVO record);

    int insertSelective(OmsCartItemVO record);

    OmsCartItemVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsCartItemVO record);

    int updateByPrimaryKey(OmsCartItemVO record);

    List<OmsCartItemVO> getCartInfo(OmsCartItemVO cartVO);


}