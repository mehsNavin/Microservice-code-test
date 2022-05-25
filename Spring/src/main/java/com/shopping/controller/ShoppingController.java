package com.shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Transaction;
import com.shopping.service.ShoppingService;

@RestController
public class ShoppingController {
	
	@Autowired
	private ShoppingService shoppingService;

	@PostMapping("/create")
	public ResponseEntity<String> addTransaction(@Valid @RequestBody Transaction transaction) {
		return new ResponseEntity<String>(shoppingService.addTransaction(transaction),HttpStatus.OK);
	}
	
	@GetMapping("/getcustomer/{customerId}")
	public ResponseEntity<String> getCustomerCost(@PathVariable String customerId) {
	    return new ResponseEntity<String>(shoppingService.getCustomerCost(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/getproduct/{productId}")
	public ResponseEntity<String> getProductCost(@PathVariable String productId) {
	    return new ResponseEntity<String>(shoppingService.getProductCost(productId),HttpStatus.OK);
	}
	
	@GetMapping("/getTransactionCount/{locationId}")
	public ResponseEntity<String> getTransactionsByLocation(@PathVariable String locationId) {
	    return new ResponseEntity<String>(shoppingService.getTransactionsByLocation(locationId),HttpStatus.OK);
	}
}
