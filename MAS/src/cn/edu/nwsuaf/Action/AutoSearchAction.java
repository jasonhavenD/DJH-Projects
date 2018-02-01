package cn.edu.nwsuaf.Action;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;



import cn.edu.nwsuaf.Service.Impl.TeacherService;


import com.opensymphony.xwork2.ActionSupport;

public class AutoSearchAction extends ActionSupport {
	private static final long serialVersionUID = 1627454768007677969L;
	private TeacherService teacherService =new TeacherService() ;
	
	private int rol;

	private String userId;
	private String role;
	private String idname;
		
	

	public void autoSearch(){
		try{
			idname = URLDecoder.decode(new String(idname.getBytes("ISO-8859-1"),"UTF-8"),"UTF-8");
			List<Object[]> resultList= teacherService.autoSearch(userId,role,idname);
			
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/xml;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("<?xml version='1.0' encoding='UTF-8' ?>");  
			response.getWriter().write("<response>");
			if(resultList != null && resultList.size() > 0){
			for(Object[] obj : resultList){
				String id = obj[0].toString();
				if(id.indexOf(idname) >= 0)
					id = id.substring(0,id.indexOf(idname))+"$1"+id.substring(id.indexOf(idname),id.indexOf(idname)+idname.length())+"$2"+id.substring(id.indexOf(idname)+idname.length());
			    String name = obj[1].toString();
			    if(name.indexOf(idname) >= 0)
			    	name = name.substring(0,name.indexOf(idname))+"$1"+name.substring(name.indexOf(idname),name.indexOf(idname)+idname.length())+"$2"+name.substring(name.indexOf(idname)+idname.length());
				response.getWriter().write("<ids>"+id+"</ids>");
				response.getWriter().write("<names>"+name+"</names>");
			}
			}
			response.getWriter().write("</response>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getIdname() {
		return idname;
	}
	public void setIdname(String idname) {
		this.idname = idname;
	}
}
