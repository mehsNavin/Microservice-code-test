package com.shopping.model;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@FutureOrPresent(message= "Transaction Date cannot be in Past")
	private Date transactionTime;
	
	private String customerID;
	
	private int quantity;
	
	private String productCode;
	
	
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

	
	public Date getDate() {
		return transactionTime;
	}

	public void setDate(Date date) {
		this.transactionTime = date;
	}

}
