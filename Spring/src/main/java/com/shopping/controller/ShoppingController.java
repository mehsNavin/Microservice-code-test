package com.shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Transaction;

@RestController
public class ShoppingController {

	@PostMapping("/create")
	@ResponseBody
	public String createProduct(@RequestBody Transaction transaction) {
	    // custom logic
	    System.out.println("Service created!");
	    return transaction.toString();
	}
	
	@GetMapping("/getCustomer/{customerId}")
	@ResponseBody
	public String getCustomerCost(@PathVariable String customerId) {
	    // custom logic
	    System.out.println("Customer working!");
	    return customerId;
	}
	
	@GetMapping("/getProduct/{productId}")
	@ResponseBody
	public String getProductCost(@PathVariable String productId) {
	    // custom logic
	    System.out.println("Product working!");
	    return productId;
	}
}
