package com.model.newservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.newdao.NewCommentDAO;
import com.newentity.NewComment;

@Service
public class NewCommentService {
	@Resource
    private NewCommentDAO commentDAO;
	
	//获取产品评论
	@SuppressWarnings("rawtypes")
	public List<NewComment> getCommentByProductId(Integer productid){
		return commentDAO.getCommentByProductId(productid);
	}
}
