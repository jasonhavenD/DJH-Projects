package cn.edu.nwsuaf.bean;

/**
 * Teacherachievements entity. @author MyEclipse Persistence Tools
 */

public class Teacherachievements implements java.io.Serializable {

	// Fields

	private Integer techArcNo;
	private Teacher teacher;
	private Achievements achievements;
	private Integer teachRank;
	private String beizhu;

	// Constructors

	/** default constructor */
	public Teacherachievements() {
	}

	/** minimal constructor */
	public Teacherachievements(Integer techArcNo) {
		this.techArcNo = techArcNo;
	}

	/** full constructor */
	public Teacherachievements(Integer techArcNo, Teacher teacher,
			Achievements achievements, Integer teachRank, String beizhu) {
		this.techArcNo = techArcNo;
		this.teacher = teacher;
		this.achievements = achievements;
		this.teachRank = teachRank;
		this.beizhu = beizhu;
	}

	// Property accessors

	public Integer getTechArcNo() {
		return this.techArcNo;
	}

	public void setTechArcNo(Integer techArcNo) {
		this.techArcNo = techArcNo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Achievements getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Achievements achievements) {
		this.achievements = achievements;
	}

	public Integer getTeachRank() {
		return this.teachRank;
	}

	public void setTeachRank(Integer teachRank) {
		this.teachRank = teachRank;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}