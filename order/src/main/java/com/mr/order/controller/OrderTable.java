package com.mr.order.controller;

import com.mr.common.result.ResultVO;
import com.mr.order.po.OmsOrderItemPO;
import com.mr.order.service.OrderTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orderTable")
public class OrderTable {

    @Autowired
    private OrderTableService orderTableService;

    @GetMapping("list")
    public List<OmsOrderItemPO> listOrderItem(Long userId){
        userId = 1L;
        return orderTableService.list(userId);
    }

    @PostMapping("updateSp14")
    public ResultVO updateSp1(Long id){
        return orderTableService.updateSp1(id);
    }

    @PostMapping("commentList")
    public List<OmsOrderItemPO> comment(Long id) {
        List<OmsOrderItemPO> list=orderTableService.listUpdate(id);
        return list;
    }

    @PostMapping("updateSp13")
    public ResultVO updateSp13(Long id){
        return orderTableService.updateSp13(id);
    }

    //新增订单接口
    @PostMapping("addOrder")
    public ResultVO addOrder(OmsOrderItemPO omsOrderItemPO){

        return orderTableService.addOrder(omsOrderItemPO);
    }
}
