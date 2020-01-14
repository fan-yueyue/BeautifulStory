package com.mr.order.service.impl;

import com.mr.common.result.ResultVO;
import com.mr.order.mapper.CommentMapper;
import com.mr.order.po.CommentPO;
import com.mr.order.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultVO addCom(CommentPO commentPO) {
        commentPO.setMemberNickName("test");
        commentPO.setCreateTime(new Date());
        commentPO.setShowStatus(1);
        commentPO.setStar(5);
        commentPO.setMemberIp("");
        commentMapper.addCom(commentPO);
        return new ResultVO();
    }

    @Override
    public Integer listCom(Long productId) {
        List<CommentPO> list = commentMapper.listCom(productId);
        if(list.size() ==0){
            return 0;
        }
        return 1;
    }

    @Override
    public List<CommentPO> listCom2(Long orderTimeId) {
        List<CommentPO> commentPOS = commentMapper.listCom2(orderTimeId);
        System.out.println(commentPOS);
        return commentPOS;
    }
}
