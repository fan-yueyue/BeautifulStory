package com.mr.home.service;

import com.mr.common.result.ResultVO;

public interface HomeService {
    ResultVO getCarousel();

    ResultVO getBrand();

    ResultVO getProductByBrandId();
}
