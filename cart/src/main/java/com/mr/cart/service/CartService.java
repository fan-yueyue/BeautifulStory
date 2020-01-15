package com.mr.cart.service;

import com.mr.common.result.ResultVO;
import com.mr.common.vo.OmsCartItemVO;
import com.mr.common.vo.PmsProductVO;

import java.util.List;

public interface CartService {
    List<OmsCartItemVO> getCartList(OmsCartItemVO cartVO);

    void toDeleteCart(Integer id);

    ResultVO addCart(PmsProductVO productVO);

    ResultVO addCount(OmsCartItemVO cartItemVO,Integer quantity);
}
