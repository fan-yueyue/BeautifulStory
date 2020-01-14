package com.mr.admin.service.impl;

import com.mr.admin.entity.UmsMenberReceiveAddress;
import com.mr.admin.mapper.UmsMenberReceiveAddressMapper;
import com.mr.admin.service.UmsMenberReceiveAddressService;
import com.mr.common.result.ResultCode;
import com.mr.common.result.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UmsMenberReceiveAddressImpl
 * @Description: TODO
 * @Author fantueyue
 * @Date 2020/1/10
 * @Version V1.0
 **/
@Service
public class UmsMenberReceiveAddressImpl implements UmsMenberReceiveAddressService {

    @Resource
    private UmsMenberReceiveAddressMapper umsMenberReceiveAddressMapper;

    @Override
    public ResultVO selecMemberId(Long id) {
        ResultVO resultVO = new ResultVO();
        List<UmsMenberReceiveAddress> list=umsMenberReceiveAddressMapper.selecMemberId(id);
        resultVO.setDataList(list);
        return resultVO;
    }

    @Override
    public ResultVO save(UmsMenberReceiveAddress umsMenberReceiveAddress) {
        System.out.println(umsMenberReceiveAddress);
        ResultVO resultVO = new ResultVO();
        try {
            //umsMenberReceiveAddress.setMemberId(1);
            umsMenberReceiveAddressMapper.insertSelective(umsMenberReceiveAddress);
        } catch (Exception e) {
            e.printStackTrace();
            //resultVO.setCode(ResultCode.FAILED.getCode());
            resultVO.setError(ResultCode.FAILED.getMessage());
        }
        return resultVO;
    }

    @Override
    public ResultVO update(UmsMenberReceiveAddress umsMenberReceiveAddress) {
        //UmsMenberReceiveAddress umsMen=new UmsMenberReceiveAddress();
        ResultVO resultVO = new ResultVO();
        try {
            umsMenberReceiveAddressMapper.updateByPrimaryKeySelective(umsMenberReceiveAddress);
        } catch (Exception e) {
            e.printStackTrace();
            //resultVO.setCode(ResultCode.FAILED.getCode());
            resultVO.setError(ResultCode.FAILED.getMessage());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = new ResultVO();
        try {
            umsMenberReceiveAddressMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            //resultVO.setCode(ResultCode.FAILED.getCode());
            resultVO.setError(ResultCode.FAILED.getMessage());
        }
        return resultVO;
    }

    @Override
    public ResultVO selecById(Long id) {
        ResultVO resultVO = new ResultVO();
        List<UmsMenberReceiveAddress> list=umsMenberReceiveAddressMapper.selectByPrimaryKey(id);
        resultVO.setDataList(list);
        return resultVO;
    }

   @Override
    public ResultVO defaultAddress(UmsMenberReceiveAddress umsMenberReceiveAddress) {
        ResultVO resultVO = new ResultVO();
        try{
            UmsMenberReceiveAddress umsMenberReceiveAddress1 = new UmsMenberReceiveAddress();
            umsMenberReceiveAddress1.setId(umsMenberReceiveAddress.getId());
            umsMenberReceiveAddress1.setDefaultStatus(0);
            umsMenberReceiveAddressMapper.defaultAddress(umsMenberReceiveAddress1);
        }catch (Exception e){
            resultVO.setError(ResultCode.FAILED.getMessage());
        }
        return resultVO;
    }


}
