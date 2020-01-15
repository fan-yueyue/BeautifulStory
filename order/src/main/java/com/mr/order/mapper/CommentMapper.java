package com.mr.order.mapper;

import com.mr.order.po.CommentPO;
import com.mr.order.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentVO record);

    int insertSelective(CommentVO record);

    CommentVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentVO record);

    int updateByPrimaryKeyWithBLOBs(CommentVO record);

    int updateByPrimaryKey(CommentVO record);

    void addCom(CommentPO commentPO);

    List<CommentPO> listCom(Long productId);

    List<CommentPO> listCom2(Long orderTimeId);
}