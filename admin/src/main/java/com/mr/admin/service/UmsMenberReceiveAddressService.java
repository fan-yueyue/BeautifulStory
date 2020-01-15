package com.mr.admin.service;

import com.mr.admin.entity.Address;
import com.mr.admin.entity.UmsMenberReceiveAddress;
import com.mr.common.result.ResultVO;


public interface UmsMenberReceiveAddressService {

    ResultVO selecMemberId(Long id,Address address);

    ResultVO save(UmsMenberReceiveAddress umsMenberReceiveAddress);

    ResultVO update(UmsMenberReceiveAddress umsMenberReceiveAddress);

    ResultVO delete(Long id);

    ResultVO selecById(Long id);


    ResultVO defaultAddress(UmsMenberReceiveAddress umsMenberReceiveAddress);

    ResultVO selectAddress(Address address);

    ResultVO selectCity(Integer id);
}
