package cn.edu.nwsuaf.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * FileinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class FileinfoAttachment implements java.io.Serializable {

	// Fields

	private String attachmentId;
	private Mas mas;
	private String orginalName;
	private String actualName;
	private String actualPath;
	private String year;
	private Timestamp uploadDate;
	private String uploadPerson;
	private String indexFileType;
	private Float asseisingValue;
	private Integer tag;
	private Integer uploadStatus;
	private Set expertscores = new HashSet(0);
	private Set expertscores_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public FileinfoAttachment() {
	}

	/** minimal constructor */
	public FileinfoAttachment(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/** full constructor */
	public FileinfoAttachment(String attachmentId, Mas mas, String orginalName,
			String actualName, String actualPath, String year,
			Timestamp uploadDate, String uploadPerson, String indexFileType,
			Float asseisingValue, Integer tag, Integer uploadStatus,
			Set expertscores, Set expertscores_1) {
		this.attachmentId = attachmentId;
		this.mas = mas;
		this.orginalName = orginalName;
		this.actualName = actualName;
		this.actualPath = actualPath;
		this.year = year;
		this.uploadDate = uploadDate;
		this.uploadPerson = uploadPerson;
		this.indexFileType = indexFileType;
		this.asseisingValue = asseisingValue;
		this.tag = tag;
		this.uploadStatus = uploadStatus;
		this.expertscores = expertscores;
		this.expertscores_1 = expertscores_1;
	}

	// Property accessors

	public String getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Mas getMas() {
		return this.mas;
	}

	public void setMas(Mas mas) {
		this.mas = mas;
	}

	public String getOrginalName() {
		return this.orginalName;
	}

	public void setOrginalName(String orginalName) {
		this.orginalName = orginalName;
	}

	public String getActualName() {
		return this.actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getActualPath() {
		return this.actualPath;
	}

	public void setActualPath(String actualPath) {
		this.actualPath = actualPath;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Timestamp getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadPerson() {
		return this.uploadPerson;
	}

	public void setUploadPerson(String uploadPerson) {
		this.uploadPerson = uploadPerson;
	}

	public String getIndexFileType() {
		return this.indexFileType;
	}

	public void setIndexFileType(String indexFileType) {
		this.indexFileType = indexFileType;
	}

	public Float getAsseisingValue() {
		return this.asseisingValue;
	}

	public void setAsseisingValue(Float asseisingValue) {
		this.asseisingValue = asseisingValue;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Integer getUploadStatus() {
		return this.uploadStatus;
	}

	public void setUploadStatus(Integer uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public Set getExpertscores() {
		return this.expertscores;
	}

	public void setExpertscores(Set expertscores) {
		this.expertscores = expertscores;
	}

	public Set getExpertscores_1() {
		return this.expertscores_1;
	}

	public void setExpertscores_1(Set expertscores_1) {
		this.expertscores_1 = expertscores_1;
	}

}