package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.sf.json.JSONObject;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.bean.Assessingproject;

public class timeManage{
	private static final long serialVersionUID = 7078254784406906185L;
	 
	private List<Assessingproject> assessingprojectList=new ArrayList<Assessingproject>();// 评估项目
	private AssessingprojectService anewService;
	private JSONObject json;
    
    public String testAjax(){
    	json=new JSONObject();
        assessingprojectList = anewService.findByHQL("from Assessingproject as a where a.masprojectNo in(select max(masprojectNo) from Assessingproject where tag='1')");
        System.out.println("assessingprojectListsize  "+assessingprojectList.size());
        for (int i = 0; i < assessingprojectList.size(); i++) {
        	Date dt1 = assessingprojectList.get(0).getMasprojectEndDate();
            Date dt2 = Calendar.getInstance().getTime();
            if(dt1.getTime()<dt2.getTime()){//已经超过评估结束时间
            	json.put("status", "fail");
            }else{//评估时间内
            	System.out.println(">");
            	json.put("status","success");
            }
        }
    	
    	return "success";
    }

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public AssessingprojectService getAnewService() {
		return anewService;
	}

	public void setAnewService(AssessingprojectService anewService) {
		this.anewService = anewService;
	}
    
}
