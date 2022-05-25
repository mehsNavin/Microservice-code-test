package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.ShoppingDAO;
import com.shopping.model.Transaction;

@Service
public class ShoppingService {

	@Autowired
	private ShoppingDAO shoppingDAO;
	
	public String addTransaction(Transaction transaction){
		return shoppingDAO.addTransaction(transaction);
	}

	public String getCustomerCost(String customerId){
		return shoppingDAO.getCustomerCost(customerId);
	}

	public String getProductCost(String productId){
		return shoppingDAO.getProductCost(productId);
	}
	
	public String getTransactionsByLocation(String locationId){
		return shoppingDAO.getTransactionsByLocation(locationId);
	}
	
}
