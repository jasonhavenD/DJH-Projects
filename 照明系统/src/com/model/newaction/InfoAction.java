package com.model.newaction;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.entity.Producttype;
import com.model.newservice.NewInformationService;
import com.newentity.Homeslides;
import com.newentity.NewInformation;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.publicentity.Page;
//@Entity
//@Controller
public class InfoAction extends ActionSupport {
	private NewInformation information;
	private List<NewInformation> infoList;
	
	private Integer infoid;
	private Integer typeid;
	private String typename;
	
	private HttpServletRequest request; // = ServletActionContext.getRequest();
	
	@Resource
	private NewInformationService informationservice;
	
	public InfoAction() {
		
	}
	
	public NewInformation getInformation() {
		return information;
	}
	public void setInformation(NewInformation information) {
		this.information = information;
	}

	public List<NewInformation> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<NewInformation> infoList) {
		this.infoList = infoList;
	}
	
	public Integer getInfoid() {
		return infoid;
	}
	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}
	
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

	public NewInformationService getInformationservice() {
		return informationservice;
	}
	public void setInformationservice(NewInformationService informationservice) {
		this.informationservice = informationservice;
	}
	
	public String getInformationDetail() throws Exception{
		//获取页面详细信息
		//request = ServletActionContext.getRequest();
		//Integer informationid = Integer.valueOf(request.getParameter("informationid"));
		information=informationservice.getInfoDetailById(infoid);
		return Action.SUCCESS;
	}
	
	public String getInfoDetail1stByTypename() throws Exception{
		//获取页面详细信息
		System.out.println("in getInfoDetail1stByTypename()");
		information = informationservice.getInfoListByTypename(typename).get(0);
		System.out.println("information: " + information);
		return Action.SUCCESS;
	}
	
	public String getInformationList0() throws Exception {
		request = ServletActionContext.getRequest();
		Integer type = Integer.valueOf(request.getParameter("type"));
		int pageIndex=1; //默认页数为1
		int pageSize=Integer.valueOf(request.getParameter("pageSize")); //当前页数
		int pagelist=12; //当前显示条数
		Page page =(Page) ServletActionContext.getPageContext().getPage();
		page.setPageSize(pageSize);
		page.setPageIndex(pageIndex);
		page.setTotalCount(pagelist);
		infoList=informationservice.getInfoListByType(type, page);
		return Action.SUCCESS;
	}
	
	public String getInformationList1() throws Exception {
		System.out.println("in getInformationList()");
		request = ServletActionContext.getRequest();
		Integer type = Integer.valueOf(request.getParameter("type"));
		int pageIndex = 1;//默认页数为1
		int pageSize = Integer.valueOf(request.getParameter("pageSize"));//当前总页数
		int totalCount = informationservice.getInfoCountByType(type); //该类别的咨询的总条数
//		System.out.println("type: " + type);
//		System.out.println("pageIndex: " + pageIndex);
//		System.out.println("pageSize: " + pageSize);
//		System.out.println("totalCount: " + totalCount);
		Page page =new Page(pageIndex, pageSize, totalCount);
		infoList = informationservice.getInfoListByType(type, page);
		System.out.println("infoList.size(): " + infoList.size());
		Object[] infos = infoList.toArray();
		System.out.println("infoList: " + ((NewInformation)infos[0]).getInformationtitle() + " " + ((NewInformation)infos[0]).getPublishdatetime());
		
		return Action.SUCCESS;
	}
	
	public String getInformationList() throws Exception {
		System.out.println("in getInformationList()");
		int pageIndex = 1;//默认页数为1
		request = ServletActionContext.getRequest();
		int pageSize = Integer.valueOf(request.getParameter("pageSize"));//当前总页数
		int totalCount = informationservice.getInfoCountByTypename(typename); //该类别的咨询的总条数
//		System.out.println("type: " + type);
//		System.out.println("pageIndex: " + pageIndex);
//		System.out.println("pageSize: " + pageSize);
//		System.out.println("totalCount: " + totalCount);
		Page page =new Page(pageIndex, pageSize, totalCount);
		infoList = informationservice.getInfoListByTypename(typename, page);
		System.out.println("infoList.size(): " + infoList.size());
		Object[] infos = infoList.toArray();
		System.out.println("infoList: " + ((NewInformation)infos[0]).getInformationtitle() + " " + ((NewInformation)infos[0]).getPublishdatetime());
		
		return Action.SUCCESS;
	}
}
