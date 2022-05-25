package com.shopping.database.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

	@Id @GeneratedValue
	@Column(name = "ProductCode")
	private String productCode;
	
	@Column(name = "Cost")
	private String Cost;
	
	@Column(name = "Status")
	private String status;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
