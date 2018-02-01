package cn.edu.nwsuaf.Model;



public class TeachBooksModel extends BaseModel{
	private Integer tbno;
	private String isbn;
	private String publisher;
	private String publishTime;
	private String publishType;
	private String tbookJibie;
	private String tbookClass;
	private String tbookRewardClass;
	private Integer bookWords;
	private String useState;
	private String fininshDepartRate;
	private String beizhu;
	private Integer tag;

	public TeachBooksModel() {
		super();
	}


	public Integer getTbno() {
		return tbno;
	}


	public void setTbno(Integer tbno) {
		this.tbno = tbno;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishType() {
		return publishType;
	}

	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}

	public String getTbookJibie() {
		return tbookJibie;
	}

	public void setTbookJibie(String tbookJibie) {
		this.tbookJibie = tbookJibie;
	}

	public String getTbookClass() {
		return tbookClass;
	}

	public void setTbookClass(String tbookClass) {
		this.tbookClass = tbookClass;
	}

	public String getTbookRewardClass() {
		return tbookRewardClass;
	}

	public void setTbookRewardClass(String tbookRewardClass) {
		this.tbookRewardClass = tbookRewardClass;
	}

	
	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}


	public void setBookWords(Integer bookWords) {
		this.bookWords = bookWords;
	}


	public Integer getBookWords() {
		return bookWords;
	}


	public void setUseState(String useState) {
		this.useState = useState;
	}


	public String getUseState() {
		return useState;
	}


	public void setFininshDepartRate(String fininshDepartRate) {
		this.fininshDepartRate = fininshDepartRate;
	}


	public String getFininshDepartRate() {
		return fininshDepartRate;
	}


}
