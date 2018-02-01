package com.newentity;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * NewInformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="information"
    ,schema="dbo"
    ,catalog="NewLightSystem"
)

public class NewInformation  implements java.io.Serializable {


    // Fields    

     private Integer informationid;
     private String informationtitle;
     private String informationcontent; //内容为HTML格式，可直接显示
     private Timestamp publishdatetime;
     private Integer publishuserid;
     private String attchmentspath;
     private Integer type;
     private Integer hits;
     private String typename;


    // Constructors

  	/** default constructor */
    public NewInformation() {
    }

	/** minimal constructor */
    public NewInformation(String informationtitle, Timestamp publishdatetime) {
        this.informationtitle = informationtitle;
        this.publishdatetime = publishdatetime;
    }
    
    /** full constructor */
    public NewInformation(String informationtitle, String informationcontent, Timestamp publishdatetime, Integer publishuserid, String attchmentspath, Integer type, Integer hits, String typename) {
        this.informationtitle = informationtitle;
        this.informationcontent = informationcontent;
        this.publishdatetime = publishdatetime;
        this.publishuserid = publishuserid;
        this.attchmentspath = attchmentspath;
        this.type = type;
        this.hits = hits;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="informationid", unique=true, nullable=false)

    public Integer getInformationid() {
        return this.informationid;
    }
    
    public void setInformationid(Integer informationid) {
        this.informationid = informationid;
    }
    
    @Column(name="informationtitle", nullable=false, length=50)

    public String getInformationtitle() {
    	return this.informationtitle;
    }
    
    public void setInformationtitle(String informationtitle) {
    	this.informationtitle = informationtitle;
    }
    
    @Column(name="informationcontent")

    public String getInformationcontent() {
        return this.informationcontent;
    }
    
    public void setInformationcontent(String informationcontent) {
        this.informationcontent = informationcontent;
    }
    
    @Column(name="publishdatetime", nullable=false, length=23)

    public Timestamp getPublishdatetime() {
    	return this.publishdatetime;
    }
    
    public void setPublishdatetime(Timestamp publishdatetime) {
    	this.publishdatetime = publishdatetime;
    }
    
    @Column(name="publishuserid")

    public Integer getPublishuserid() {
        return this.publishuserid;
    }
    
    public void setPublishuserid(Integer publishuserid) {
        this.publishuserid = publishuserid;
    }
    
    @Column(name="attchmentspath", length=100)

    public String getAttchmentspath() {
        return this.attchmentspath;
    }
    
    public void setAttchmentspath(String attchmentspath) {
        this.attchmentspath = attchmentspath;
    }
    
    @Column(name="type")

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    @Column(name="hits")

    public Integer getHits() {
        return this.hits;
    }
    
    public void setHits(Integer hits) {
        this.hits = hits;
    }
    
    @Column(name="typename")
    public String getTypename() {
  		return typename;
  	}

  	public void setTypename(String typename) {
  		this.typename = typename;
  	}

}