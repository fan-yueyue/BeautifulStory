package com.mr.admin.service;

import com.mr.admin.entity.UmsMenberReceiveAddress;
import com.mr.common.result.ResultVO;

import java.util.List;

public interface UmsMenberReceiveAddressService {

    ResultVO selecMemberId(Long id);

    ResultVO save(UmsMenberReceiveAddress umsMenberReceiveAddress);

    ResultVO update(UmsMenberReceiveAddress umsMenberReceiveAddress);

    ResultVO delete(Long id);

    ResultVO selecById(Long id);


    ResultVO defaultAddress(UmsMenberReceiveAddress umsMenberReceiveAddress);
}
