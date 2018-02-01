package com.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.newentity.NewProduct;


/**
 * Producttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="producttype"
    ,schema="dbo"
    ,catalog="NewLightSystem"
)

public class Producttype1  implements java.io.Serializable {


    // Fields    

     private Integer producttypeid;
     private String producttypename;
     private Integer parentproducttypeid;
     private String producttypepicturepath;
     private Integer typecount;
     private Set<Product> products = new HashSet<Product>(0);


    // Constructors

    /** default constructor */
    public Producttype1() {
    }

	/** minimal constructor */
    public Producttype1(Integer producttypeid, String producttypename) {
        this.producttypeid = producttypeid;
        this.producttypename = producttypename;
    }
    
    /** full constructor */
    public Producttype1(Integer producttypeid, String producttypename, Integer parentproducttypeid, String producttypepicturepath, Set<Product> products, Integer typecount) {
        this.producttypeid = producttypeid;
        this.producttypename = producttypename;
        this.parentproducttypeid = parentproducttypeid;
        this.producttypepicturepath = producttypepicturepath;
        this.products = products;
        this.typecount = typecount;
    }

   
    // Property accessors
    @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "producttypeid", unique = true, nullable = false)
    public Integer getProducttypeid() {
        return this.producttypeid;
    }
    
    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }
    
    @Column(name="producttypename", nullable=false, length=50)

    public String getProducttypename() {
        return this.producttypename;
    }
    
    public void setProducttypename(String producttypename) {
        this.producttypename = producttypename;
    }
    
    @Column(name="parentproducttypeid")

    public Integer getParentproducttypeid() {
        return this.parentproducttypeid;
    }
    
    public void setParentproducttypeid(Integer parentproducttypeid) {
        this.parentproducttypeid = parentproducttypeid;
    }
    
    @Column(name="producttypepicturepath", length=100)

    public String getProducttypepicturepath() {
        return this.producttypepicturepath;
    }
    
    public void setProducttypepicturepath(String producttypepicturepath) {
        this.producttypepicturepath = producttypepicturepath;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="producttype")

    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
   
    
    @Column(name = "typecount")
	public Integer getTypecount() {
		return typecount;
	}

	public void setTypecount(Integer typecount) {
		this.typecount = typecount;
	}
	
}