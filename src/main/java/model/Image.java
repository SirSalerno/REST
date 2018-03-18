package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "image")
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {
 
    private String id;
    private String type;
    private String productID;
 
    
    public Image() {
 
    }
 
    public Image(String id, String type, String productID) {
        this.id = id;
        this.type = type;
        this.productID = productID;
    }
 
    public String getImgID() {
        return id;
    }
 
    public void setImgID(String id) {
        this.id = id;
    }
 
    public String getProdName() {
        return type;
    }
 
    public void setProdName(String type) {
        this.type = type;
    }
    
    public String getProductID() {
        return productID;
    }
 
    public void setProductID(String productID) {
        this.productID = productID;
    }
 
}