package com.mr.order.service;

import com.mr.common.result.ResultVO;
import com.mr.order.po.CommentPO;

import java.util.List;

public interface CommentService {
    ResultVO addCom(CommentPO commentPO);

    Integer listCom(Long productId);

    List<CommentPO> listCom2(Long orderTimeId);
}
