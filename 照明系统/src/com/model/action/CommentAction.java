package com.model.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Comment;
import com.entity.Company;
import com.entity.Orderdetail;
import com.entity.Orderinfo;
import com.entity.Product;
import com.entity.Userinfo;
import com.model.dao.CommentDAO;
import com.model.service.CommentService;
import com.model.service.OrderService;
import com.model.service.ProductService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

@Entity
@Controller
@Scope("prototype")
public class CommentAction implements ModelDriven<Comment> {

	private HashMap<String, Object> hashmap = new HashMap<String, Object>();
	@ManyToOne
	private Comment comment = new Comment();
	@ManyToOne
	private Company company = new Company();
	@ManyToOne
	private Product product = new Product();
	private HttpServletRequest request;
	private HttpServletResponse response;
	@ManyToOne
	@Resource
	private CommentService commentService;
	@ManyToOne
	@Resource
	private OrderService orderService;
	@ManyToOne
	@Resource
	private ProductService productService;

	public String addComment() {
		
		
		try {
			request = ServletActionContext.getRequest();
			Integer orderid = Integer.parseInt(request.getParameter("orderid"));
			Integer productid = Integer.parseInt(request.getParameter("productid"));
			product = productService.findById(productid);
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			company.setCompanyid(userinfo.getUserinfoid());

			// 获取评论内容
			String content = request.getParameter("content");
			System.out.println(content);
			comment.setCommentcontent(content);
			comment.setCompany(company);
			comment.setProduct(product);
			comment.setState(0);

			commentService.saveComment(comment);// 将评论插入数据库
			orderService.finish(orderid);
			hashmap.put("state", "success");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	//审核评论
	public String checkComment(){
		try {
			List<Map> list = commentService.findZero();
			hashmap.put("state", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	//审核评论
	/*public String reviewComment() throws IOException{
		
		//request = ServletActionContext.getRequest();
		//查找数据库中 state=0 的评论内容
		try {
			List list = commentService.findByState(0);
			System.out.println("审核 情况"+list);
			hashmap.put("state", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}*/
	//通过或者不通过
	public String yesOrNo(){
		try {
			request = ServletActionContext.getRequest();
			Integer state = Integer.parseInt(request.getParameter("state"));
			Integer commentid = Integer.parseInt(request.getParameter("commentid"));
			//根据state的值来判断，若state == 1 则根据 commentid 删除该条评论；若 state == 2，则更新该评论状态；
			if(state == 1){//不通过
				commentService.deleteByCommentId(commentid);

			}else{//通过
				commentService.updateStateByCommentId(commentid);
			}
			hashmap.put("state", "success");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	//查询通过
	public String stateTwo(){
		try {
			List<Map> list = commentService.findTwo();
			hashmap.put("state", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public Comment getModel() {
		return comment;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
