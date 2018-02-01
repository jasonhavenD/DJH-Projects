package com.model.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;


import com.entity.Comment;
import com.model.dao.CommentDAO;

@Entity
@Service
public class CommentService {
	@ManyToOne
	@Resource
	
	private CommentDAO commentdao;
	/**
	 * �������
	 */
	public void saveComment(Comment comment){
		commentdao.save(comment);
	}
	/**
	 * ���ID��ѯ����
	 */
	public Comment findById(Integer id){
		return commentdao.findById(id);
	}
	/**
	 * 根据commentid删除评论
	 */
	public void deleteByCommentId(Integer commentid){
		commentdao.deleteByCommentId(commentid);
	}
	// 根据commentid更新state值
	public void updateStateByCommentId(Integer commentid){
		commentdao.updateStateByCommentId(commentid);
	}
	/*
	 * ����ȫ������ 
	 */
	public List<Comment> findAll(){
		return commentdao.findAll();
	}
	//wsp
	public List<Map> findZero(){
		return commentdao.findZero();
	}
	public List<Map> findTwo(){
		return commentdao.findTwo();
	}
	public List findByState(Object state) {
		return commentdao.findByState(state);
	}
}
