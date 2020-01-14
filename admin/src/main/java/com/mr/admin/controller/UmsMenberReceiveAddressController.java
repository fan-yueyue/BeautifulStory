package com.mr.admin.controller;

import com.mr.admin.entity.Address;
import com.mr.admin.entity.UmsMenberReceiveAddress;
import com.mr.admin.service.UmsMenberReceiveAddressService;
import com.mr.common.result.ResultCode;
import com.mr.common.result.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UmsMenberReceiveAddressController
 * @Description: TODO
 * @Author fantueyue
 * @Date 2020/1/10
 * @Version V1.0
 **/
@RestController
@RequestMapping("umsMenberReceiveAddress")
public class UmsMenberReceiveAddressController {
    @Autowired
    private UmsMenberReceiveAddressService umsMenberReceiveAddressService;

    @GetMapping(value="selectMemberId")
    public ResultVO selecMemberId(Long id,Address address){
        id=1L;
        return umsMenberReceiveAddressService.selecMemberId(id,address);
    }

    @GetMapping(value="selectById")
    public ResultVO selecById(Long id){
        return umsMenberReceiveAddressService.selecById(id);
    }

    @PostMapping(value = "save")
    public ResultVO save(UmsMenberReceiveAddress umsMenberReceiveAddress){

       return umsMenberReceiveAddressService.save(umsMenberReceiveAddress);
    }


    @PostMapping(value="update")
    public ResultVO update(UmsMenberReceiveAddress umsMenberReceiveAddress){
        return umsMenberReceiveAddressService.update(umsMenberReceiveAddress);
    }

    @PostMapping(value="delete")
    public ResultVO delete(Long id){
        return umsMenberReceiveAddressService.delete(id);
    }

    @PostMapping(value="defaultAddress")
    public ResultVO defaultAddress(UmsMenberReceiveAddress umsMenberReceiveAddress){
       return umsMenberReceiveAddressService.defaultAddress(umsMenberReceiveAddress);
    }


    //地址查询
    @GetMapping("selectAddress")
    public ResultVO selectAddress(Address address){
        return umsMenberReceiveAddressService.selectAddress(address);
    }

    @GetMapping("selectCity")
    public ResultVO selectCity(Integer id){
        return umsMenberReceiveAddressService.selectCity(id);
    }
}
