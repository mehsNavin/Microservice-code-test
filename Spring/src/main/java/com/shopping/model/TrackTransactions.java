package com.shopping.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TrackTransactions")
public class TrackTransactions {

	@Column(name = "TransactionTime")
	private Date transactionTime;
	
	@Id @GeneratedValue
	@Column(name = "CustomerID")
	private String customerID;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "ProductCode")
	private String productCode;

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
