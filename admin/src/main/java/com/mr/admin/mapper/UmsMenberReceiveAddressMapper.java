package com.mr.admin.mapper;

import com.mr.admin.entity.UmsMenberReceiveAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface UmsMenberReceiveAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMenberReceiveAddress record);

    int insertSelective(UmsMenberReceiveAddress record);

   List<UmsMenberReceiveAddress> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMenberReceiveAddress record);

    int updateByPrimaryKey(UmsMenberReceiveAddress record);

    List<UmsMenberReceiveAddress> selecMemberId(Long id);

    int defaultAddress(UmsMenberReceiveAddress umsMenberReceiveAddress);
}