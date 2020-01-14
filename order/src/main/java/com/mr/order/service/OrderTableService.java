package com.mr.order.service;


import com.mr.common.result.ResultVO;
import com.mr.order.po.OmsOrderItemPO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderTableService {
    List<OmsOrderItemPO> list(Long userId);

    ResultVO updateSp1(Long id);

    List<OmsOrderItemPO> listUpdate(Long id);

    ResultVO updateSp13(Long id);

    ResultVO addOrder(OmsOrderItemPO omsOrderItemPO);
}
