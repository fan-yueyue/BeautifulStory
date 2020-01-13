package com.mr.cart.controller;

import com.mr.cart.service.CartService;
import com.mr.cart.vo.OmsCartItemVO;
import com.mr.common.result.ResultCode;
import com.mr.common.result.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @RequestMapping("getCartList")
    @ResponseBody
    public ResultVO getCartList(OmsCartItemVO cartVO){
        ResultVO resultVO = new ResultVO();
        List<OmsCartItemVO> cartList = cartService.getCartList(cartVO);
        resultVO.setDataList(cartList);

        return resultVO;

    }


    @RequestMapping("deleteCartList")
    @ResponseBody
    public void deleteCartList(Integer id){
        cartService.toDeleteCart(id);
    }

    @RequestMapping("addToCart")
    @ResponseBody
    public ResultVO addToCart(OmsCartItemVO cartItemVO){
        ResultVO resultVO = cartService.addCart(cartItemVO);
        return resultVO;
    }

    @RequestMapping("addCartCount")
    @ResponseBody
    public ResultVO addCartCount(OmsCartItemVO cartItemVO,Integer quantity){
        ResultVO resultVO = cartService.addCount(cartItemVO,quantity);
        return resultVO;
    }

}
