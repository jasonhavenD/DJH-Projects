package cn.edu.nwsuaf.Action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Service.Impl.FuntionargsService;
import cn.edu.nwsuaf.Service.Impl.SummaryService;
import cn.edu.nwsuaf.bean.Studentculturesummary;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.Function;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FuntionargsService funtionargsService;
	private SummaryService summaryService;
	private int rol;
	

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	public String calculateY(){
		
		try {
			//首先是获得F值集合
			Map<String, Double>mapF= Function.loadParams();
			double F24=mapF.get("F24");
			double F25=mapF.get("F25");
			double F26=mapF.get("F26");
			
			
			List<Studentculturesummary>studentculturesummaryList=summaryService.getAllStudentculturesummaryList();
			Iterator<Studentculturesummary>iterator=studentculturesummaryList.iterator();
			while(iterator.hasNext()){
				Studentculturesummary studentculturesummary=iterator.next();
				int N1=studentculturesummary.getRaceNumber1();
				int N2=studentculturesummary.getRaceNumber2();
				int N3=studentculturesummary.getRaceNumber3();
				System.out.println("专业代码："+studentculturesummary.getMajor().getInmName()+"  国家级竞赛："+N1
						+"  省级竞赛："+N2+"  校级竞赛："+N3+" 总得分："+Function.CalculateTalents(N1, N2, N3, F24, F25, F26));
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return "error";
		}
		return SUCCESS;
	}
	
	
	public FuntionargsService getFuntionargsService() {
		return funtionargsService;
	}
	public void setFuntionargsService(FuntionargsService funtionargsService) {
		this.funtionargsService = funtionargsService;
	}
	public SummaryService getSummaryService() {
		return summaryService;
	}
	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}
  
}
