package com.mr.order.mapper;

import com.mr.order.entity.OmsOrderItem;
import com.mr.order.po.OmsOrderItemPO;

import java.util.List;

public interface OmsOrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderItem record);

    int insertSelective(OmsOrderItem record);

    OmsOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsOrderItem record);

    int updateByPrimaryKey(OmsOrderItem record);

    List<OmsOrderItemPO> list(Long userId);

    void updateSp1(Long id);

    List<OmsOrderItemPO> listUpdate(Long id);

    void updateSp13(Long id);

    void addOrder(OmsOrderItemPO omsOrderItemPO);
}