package com.shopping.database.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rowId;
	
	@Column(name = "TransactionTime")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date transactionTime;
	
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

	public long getRowId() {
		return rowId;
	}

	public void setRowId(long rowId) {
		this.rowId = rowId;
	}
}
