package com.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerResponse {
	
	private String customerID;
	private List<String> products = new ArrayList<>();
	private long totalCost = 0;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public List<String> getProducts() {
		return products;
	}
	public void addProducts(String product) {
		this.products.add(product);
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void addTotalCost(long totalCost) {
		this.totalCost += totalCost;
	}
	
	

}
