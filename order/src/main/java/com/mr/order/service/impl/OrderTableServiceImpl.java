package com.mr.order.service.impl;

import com.mr.common.result.ResultVO;
import com.mr.order.mapper.OmsOrderItemMapper;
import com.mr.order.po.OmsOrderItemPO;
import com.mr.order.service.OrderTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableServiceImpl implements OrderTableService {


    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;


    @Override
    public List<OmsOrderItemPO> list(Long userId) {
        List<OmsOrderItemPO> list = omsOrderItemMapper.list(userId);
        return list;
    }

    @Override
    public ResultVO updateSp1(Long id) {
        omsOrderItemMapper.updateSp1(id);
        return new ResultVO();
    }

    @Override
    public List<OmsOrderItemPO> listUpdate(Long id) {
        return omsOrderItemMapper.listUpdate(id);
    }

    @Override
    public ResultVO updateSp13(Long id) {
        omsOrderItemMapper.updateSp13(id);
        return  new ResultVO();
    }
}
