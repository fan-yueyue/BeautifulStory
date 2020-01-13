package com.mr.cart.service;

import com.mr.cart.vo.OmsCartItemVO;
import com.mr.common.result.ResultVO;

import java.util.List;

public interface CartService {
    List<OmsCartItemVO> getCartList(OmsCartItemVO cartVO);

    void toDeleteCart(Integer id);

    ResultVO addCart(OmsCartItemVO cartItemVO);

    ResultVO addCount(OmsCartItemVO cartItemVO,Integer quantity);
}
