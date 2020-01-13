package com.mr.cart.service.impl;

import com.mr.cart.mapper.OmsCartItemEntityMapper;
import com.mr.cart.service.CartService;
import com.mr.cart.vo.OmsCartItemVO;
import com.mr.common.result.ResultCode;
import com.mr.common.result.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OmsCartItemEntityMapper cartItemMapper;

    @Override
    public List<OmsCartItemVO>  getCartList(OmsCartItemVO cartVO) {
        List<OmsCartItemVO> list = cartItemMapper.getCartInfo(cartVO);
        return list;
    }

    @Override
    public void toDeleteCart(Integer id) {

        OmsCartItemVO omsCartItemVO = new OmsCartItemVO();
        omsCartItemVO.setId(id.longValue());
        omsCartItemVO.setDeleteStatus(1);
        cartItemMapper.updateByPrimaryKeySelective(omsCartItemVO);
    }

    @Override
    public ResultVO addCart(OmsCartItemVO cartItemVO) {
        try {
            if (cartItemVO != null){
                cartItemMapper.insertSelective(cartItemVO);
                ResultVO resultVO = new ResultVO(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
                return resultVO;
            }else{
                ResultVO resultVO = new ResultVO(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage());
                return resultVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultVO resultVO = new ResultVO(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage());
            return resultVO;
        }


    }

    @Override
    public ResultVO addCount(OmsCartItemVO cartItemVO,Integer quantity) {


        try {
            if(cartItemVO != null){
                cartItemVO.setQuantity(quantity);
                cartItemMapper.updateByPrimaryKeySelective(cartItemVO);
                ResultVO resultVO = new ResultVO(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
                return resultVO;
            }else{
                ResultVO resultVO = new ResultVO(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage());
                return resultVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultVO resultVO = new ResultVO(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage());
            return resultVO;
        }



    }
}
