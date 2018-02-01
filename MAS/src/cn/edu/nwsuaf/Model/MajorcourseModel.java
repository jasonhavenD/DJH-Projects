package cn.edu.nwsuaf.Model;

public class MajorcourseModel extends BaseModel{
	//Id代表课程编号
	//Name代表课程名称
	private String openSemester;//学期
	private String tno;//教师工号
	private String tname;//教师姓名
	private String professionalTitleName;//职称
	private String ctype;//课程类型
	public String getProfessionalTitleName() {
		return professionalTitleName;
	}
	public void setProfessionalTitleName(String professionalTitleName) {
		this.professionalTitleName = professionalTitleName;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getOpenSemester() {
		return openSemester;
	}
	public void setOpenSemester(String openSemester) {
		this.openSemester = openSemester;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
