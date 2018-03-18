package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@Entity
@Table(name = "Product")
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	
	@Column(name = "id")
	@Id
    private String id;
	@Column(name = "name")
    private String name;
	@Column(name = "description")
    private String description;
	@Column(name = "parentID")
    private String parentID;
 
    
    public Product() {
 
    }
 
    public Product(String id, String name, String description, String parentID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentID = parentID;
    }
 
    public String getProdID() {
        return id;
    }
 
    public void setProdID(String id) {
        this.id = id;
    }
 
    public String getProdName() {
        return name;
    }
 
    public void setProdName(String name) {
        this.name = name;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getParentID() {
        return parentID;
    }
 
    public void setParentID(String parentID) {
        this.parentID = parentID;
    }
 
}