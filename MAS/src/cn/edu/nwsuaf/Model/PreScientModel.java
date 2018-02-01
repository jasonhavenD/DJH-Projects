package cn.edu.nwsuaf.Model;

public class PreScientModel extends BaseModel {
	
	private String Tno;
	private String ProjecType;
	private String ProjecJibie;
	private String Tname;
	
	/***************   GETTERS & SETTERS    ***************/
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getProjecType() {
		return ProjecType;
	}
	public void setProjecType(String projecType) {
		ProjecType = projecType;
	}
	public String getProjecJibie() {
		return ProjecJibie;
	}
	public void setProjecJibie(String projecJibie) {
		ProjecJibie = projecJibie;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTname() {
		return Tname;
	}
}
