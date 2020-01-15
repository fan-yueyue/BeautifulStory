package com.mr.home.service.impl;

import com.mr.common.dto.web.PmsBrand;

import com.mr.common.dto.web.PmsProduct;
import com.mr.common.dto.web.PmsProductCateGory;
import com.mr.common.dto.web.PmsProductWithBLOBs;
import com.mr.common.result.ResultVO;
import com.mr.home.mapper.PmsBrandMapper;
import com.mr.home.mapper.PmsProductCateGoryMapper;
import com.mr.home.mapper.PmsProductMapper;
import com.mr.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    private PmsProductCateGoryMapper pmsProductCateGoryMapper;

    @Autowired
    private PmsProductMapper pmsProductMapper;
    @Override
    public ResultVO getCarousel() {
        Integer i=0;
        long id = i.longValue();
        List<PmsBrand> list= pmsBrandMapper.selectByPrimaryKey(id);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200L);
        resultVO.setDataList(list);

        return resultVO;
    }

    @Override
    public ResultVO getBrand() {
        List<PmsProductCateGory> list=pmsProductCateGoryMapper.getBrandById();

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200L);
        resultVO.setDataList(list);
        return resultVO;
    }

    @Override
    public ResultVO getProductByBrandId() {
        Integer i=0;
        long id = i.longValue();
        List<PmsBrand> list= pmsBrandMapper.selectByPrimaryKey(id);

        List<PmsProductWithBLOBs> list1=pmsProductMapper.getProduct();
        for (int j=0;j<list.size();j++){

            for (int h=0;h<list1.size();h++){
                if(list.get(j).getId()==list1.get(h).getBrandId()){
                    list.get(j).setList(list1);
                }
            }
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200L);
        resultVO.setDataList(list);
        return resultVO;
    }
}
