package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Image")
@XmlRootElement(name = "image")
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {

	@Column(name = "id")
	@Id
	private String id;
	@Column(name = "type")
	private String type;
	@Column(name = "productID")
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

}