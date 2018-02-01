package cn.edu.nwsuaf.Action;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Mas;

public class AnalyseResultAction extends ActionSupport{

	private String mno1;
	private String mno2;
	private String target;
	private String[] array;
	private MasService masService;
	private JSONObject json = new JSONObject();
    private DepartmentService departmentService;
	private MajorService majorService;
    private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	/**
	 * 初始化学院与专业信息
	 * @return
	 */
	public String initShowAssessingResult(){
		try {
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findSummaryMajor(Major.class);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	/**
	 * 显示统计结果
	 * @return
	 */
	public String showAssessingResult(){
		JSONArray jsonArray = new JSONArray();
		JSONArray averageArray = new JSONArray();
		JSONArray targetNameArray = new JSONArray();
		if("2".equals(target)){
			target = "二级指标";
		}else if("3".equals(target)){
			target = "三级指标";
		}else{
			target = "一级指标";
		}
		System.out.println("target:"+target);
		/**计算平均值**/
		//选择某一专业得出所有指标编号
		List<Mas> listOfOneMajor = findByTargetAndMno(target,"020101");
		for(int i=0;i<listOfOneMajor.size();i++){
			Mas mas = listOfOneMajor.get(i);
			//根据当前指标计算所有专业的平均分
			float average = masService.calByAssessingNeedTargetNo(mas.getAssessingneedtarget().getAssessingNeedTargetNo());
			double avg = average;
			BigDecimal  avg1  =   new BigDecimal(avg);
			double avg2 = avg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
			averageArray.add(avg2);
			targetNameArray.add(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName());
		}
		jsonArray.add( targetNameArray);
		jsonArray.add(averageArray);
		if(mno1 != null){
			System.out.println(mno1);
			array = mno1.split(",");
		}
		if(array != null && array.length > 0){
			for(int i=0;i<array.length;i++){
				JSONArray tempArray = getMajorScore(target, array[i]);
				jsonArray.add(tempArray);
			}
		}
		json.put("jsonArray", jsonArray);
		return SUCCESS;		
	}
	private JSONArray getMajorScore(String target,String mno){
		JSONArray majorArray = new JSONArray();
		List<Mas> list = findByTargetAndMno(target,mno);
		for(int i=0;i<list.size();i++){
		double score = list.get(i).getAssessingScore();
		BigDecimal  s1  =   new BigDecimal(score);
		double s2 = s1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		majorArray.add(s2);
		}
		return majorArray;
	}
	/**
	 * 根据指标级别和专业编号查询
	 * @param target
	 * @param mno
	 * @return
	 */
	private List<Mas> findByTargetAndMno(String target,String mno){
		List<Mas> list = masService.findByTargetAndMno(target, mno);
		return list;
	}
	public String getMno1() {
		return mno1;
	}
	public void setMno1(String mno1) {
		this.mno1 = mno1;
	}
	public String getMno2() {
		return mno2;
	}
	public void setMno2(String mno2) {
		this.mno2 = mno2;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	public void setMasService(MasService masService) {
		this.masService = masService;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	
}
