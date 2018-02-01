package cn.edu.nwsuaf.Model;

import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Disciplinetype;
import cn.edu.nwsuaf.bean.Majorcategory;
import cn.edu.nwsuaf.bean.Majortype;

public class MajorModel extends BaseModel {
	private String mno;
	private Department department;
	private Majorcategory majorcategory;
	private Disciplinetype disciplinetype;
	private Majortype majortype;
	private String mname;
	private Integer majorStudentNum;
	private String codeVer;
	private String inMno;
	private String inmName;
	private String menglishName;
	private String mdirectId;
	private String mdirectName;
	private String innerNo;
	private String teachernNo;
	private String enrollmentState;
	private String majorFeatures;
	private String majorTrainingObjective;
	private Integer majorLength;
	private String year;
	private String majorNew;
	private Integer majorHours;
	private Integer majorCompulsoryHours;
	private Integer majorSelectedHours;
	private Integer courseInnerTeachHours;
	private Integer practiceTeachHours;
	private Float credit;
	private Float compulsoryCredit;
	private Float selectedCredit;
	private Float focusParcticeCredit;
	private Float courseInnerTeachCredit;
	private Float practiceCredit;
	private Float outerScienticActivityCredit;
	private Integer enableState;
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Majorcategory getMajorcategory() {
		return majorcategory;
	}
	public void setMajorcategory(Majorcategory majorcategory) {
		this.majorcategory = majorcategory;
	}
	public Disciplinetype getDisciplinetype() {
		return disciplinetype;
	}
	public void setDisciplinetype(Disciplinetype disciplinetype) {
		this.disciplinetype = disciplinetype;
	}
	public Majortype getMajortype() {
		return majortype;
	}
	public void setMajortype(Majortype majortype) {
		this.majortype = majortype;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getMajorStudentNum() {
		return majorStudentNum;
	}
	public void setMajorStudentNum(Integer majorStudentNum) {
		this.majorStudentNum = majorStudentNum;
	}
	public String getCodeVer() {
		return codeVer;
	}
	public void setCodeVer(String codeVer) {
		this.codeVer = codeVer;
	}
	public String getInMno() {
		return inMno;
	}
	public void setInMno(String inMno) {
		this.inMno = inMno;
	}
	public String getInmName() {
		return inmName;
	}
	public void setInmName(String inmName) {
		this.inmName = inmName;
	}
	public String getMenglishName() {
		return menglishName;
	}
	public void setMenglishName(String menglishName) {
		this.menglishName = menglishName;
	}
	public String getMdirectId() {
		return mdirectId;
	}
	public void setMdirectId(String mdirectId) {
		this.mdirectId = mdirectId;
	}
	public String getMdirectName() {
		return mdirectName;
	}
	public void setMdirectName(String mdirectName) {
		this.mdirectName = mdirectName;
	}
	public String getInnerNo() {
		return innerNo;
	}
	public void setInnerNo(String innerNo) {
		this.innerNo = innerNo;
	}
	public String getTeachernNo() {
		return teachernNo;
	}
	public void setTeachernNo(String teachernNo) {
		this.teachernNo = teachernNo;
	}
	public String getEnrollmentState() {
		return enrollmentState;
	}
	public void setEnrollmentState(String enrollmentState) {
		this.enrollmentState = enrollmentState;
	}
	public String getMajorFeatures() {
		return majorFeatures;
	}
	public void setMajorFeatures(String majorFeatures) {
		this.majorFeatures = majorFeatures;
	}
	public String getMajorTrainingObjective() {
		return majorTrainingObjective;
	}
	public void setMajorTrainingObjective(String majorTrainingObjective) {
		this.majorTrainingObjective = majorTrainingObjective;
	}
	public Integer getMajorLength() {
		return majorLength;
	}
	public void setMajorLength(Integer majorLength) {
		this.majorLength = majorLength;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMajorNew() {
		return majorNew;
	}
	public void setMajorNew(String majorNew) {
		this.majorNew = majorNew;
	}
	public Integer getMajorHours() {
		return majorHours;
	}
	public void setMajorHours(Integer majorHours) {
		this.majorHours = majorHours;
	}
	public Integer getMajorCompulsoryHours() {
		return majorCompulsoryHours;
	}
	public void setMajorCompulsoryHours(Integer majorCompulsoryHours) {
		this.majorCompulsoryHours = majorCompulsoryHours;
	}
	public Integer getMajorSelectedHours() {
		return majorSelectedHours;
	}
	public void setMajorSelectedHours(Integer majorSelectedHours) {
		this.majorSelectedHours = majorSelectedHours;
	}
	public Integer getCourseInnerTeachHours() {
		return courseInnerTeachHours;
	}
	public void setCourseInnerTeachHours(Integer courseInnerTeachHours) {
		this.courseInnerTeachHours = courseInnerTeachHours;
	}
	public Integer getPracticeTeachHours() {
		return practiceTeachHours;
	}
	public void setPracticeTeachHours(Integer practiceTeachHours) {
		this.practiceTeachHours = practiceTeachHours;
	}
	public Float getCredit() {
		return credit;
	}
	public void setCredit(Float credit) {
		this.credit = credit;
	}
	public Float getCompulsoryCredit() {
		return compulsoryCredit;
	}
	public void setCompulsoryCredit(Float compulsoryCredit) {
		this.compulsoryCredit = compulsoryCredit;
	}
	public Float getSelectedCredit() {
		return selectedCredit;
	}
	public void setSelectedCredit(Float selectedCredit) {
		this.selectedCredit = selectedCredit;
	}
	public Float getFocusParcticeCredit() {
		return focusParcticeCredit;
	}
	public void setFocusParcticeCredit(Float focusParcticeCredit) {
		this.focusParcticeCredit = focusParcticeCredit;
	}
	public Float getCourseInnerTeachCredit() {
		return courseInnerTeachCredit;
	}
	public void setCourseInnerTeachCredit(Float courseInnerTeachCredit) {
		this.courseInnerTeachCredit = courseInnerTeachCredit;
	}
	public Float getPracticeCredit() {
		return practiceCredit;
	}
	public void setPracticeCredit(Float practiceCredit) {
		this.practiceCredit = practiceCredit;
	}
	public Float getOuterScienticActivityCredit() {
		return outerScienticActivityCredit;
	}
	public void setOuterScienticActivityCredit(Float outerScienticActivityCredit) {
		this.outerScienticActivityCredit = outerScienticActivityCredit;
	}
	public Integer getEnableState() {
		return enableState;
	}
	public void setEnableState(Integer enableState) {
		this.enableState = enableState;
	}
	
}
