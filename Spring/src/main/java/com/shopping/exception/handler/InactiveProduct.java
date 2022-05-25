package com.shopping.exception.handler;

public class InactiveProduct extends RuntimeException{

	private static final long serialVersionUID = -4454017029304697752L;

	public InactiveProduct(String message){
		super(message);
	}
}
