package cn.edu.nwsuaf.Model;

public class CourseModel extends BaseModel{
	
	private String Ctype;
	private String IsDoubleLanguageTeach;
	private String TestMode;
	
	/******************   GETTERS & SETTERS    *****************/
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String Ctype) {
		this.Ctype = Ctype;
	}
	public String getIsDoubleLanguageTeach() {
		return IsDoubleLanguageTeach;
	}
	public void setIsDoubleLanguageTeach(String IsDoubleLanguageTeach) {
		this.IsDoubleLanguageTeach = IsDoubleLanguageTeach;
	}
	public String getTestMode() {
		return TestMode;
	}
	public void setTestMode(String TestMode) {
		this.TestMode = TestMode;
	}
}
