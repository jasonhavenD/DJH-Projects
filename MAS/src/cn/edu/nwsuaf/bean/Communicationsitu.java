package cn.edu.nwsuaf.bean;



/**
 * Communicationsitu entity. @author MyEclipse Persistence Tools
 */

public class Communicationsitu  implements java.io.Serializable {


    // Fields    

     private Integer comNumber;
     private Major major;
     private String year;
     private Integer projCounts;
     private Integer stuCount;
     private String note;
     private Integer tag;


    // Constructors

    /** default constructor */
    public Communicationsitu() {
    }

    
    /** full constructor */
    public Communicationsitu(Major major, String year, Integer projCounts, Integer stuCount, String note, Integer tag) {
        this.major = major;
        this.year = year;
        this.projCounts = projCounts;
        this.stuCount = stuCount;
        this.note = note;
        this.tag = tag;
    }

   
    // Property accessors

    public Integer getComNumber() {
        return this.comNumber;
    }
    
    public void setComNumber(Integer comNumber) {
        this.comNumber = comNumber;
    }

    public Major getMajor() {
        return this.major;
    }
    
    public void setMajor(Major major) {
        this.major = major;
    }

    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }

    public Integer getProjCounts() {
        return this.projCounts;
    }
    
    public void setProjCounts(Integer projCounts) {
        this.projCounts = projCounts;
    }

    public Integer getStuCount() {
        return this.stuCount;
    }
    
    public void setStuCount(Integer stuCount) {
        this.stuCount = stuCount;
    }

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTag() {
        return this.tag;
    }
    
    public void setTag(Integer tag) {
        this.tag = tag;
    }
   








}