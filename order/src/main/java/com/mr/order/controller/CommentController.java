package com.mr.order.controller;

import com.mr.common.result.ResultVO;
import com.mr.order.po.CommentPO;
import com.mr.order.po.OmsOrderItemPO;
import com.mr.order.service.CommentService;
import com.mr.order.service.OrderTableService;
import com.mr.order.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //新增评论
    @PostMapping("addCom")
    public ResultVO addCom(CommentPO commentPO){
        commentService.addCom(commentPO);
        return new ResultVO();
    }

    @GetMapping("listCom")
    public Integer listCom(Long productId){
        Integer size = commentService.listCom(productId);
        return size;
    }

    @GetMapping("listCom2")
    public List<CommentPO> listCom2(Long orderTimeId){
        return commentService.listCom2(orderTimeId);
    }

}
