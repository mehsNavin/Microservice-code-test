package com.shopping.exception.handler;

public class TransactionCostExceeded extends RuntimeException{

	private static final long serialVersionUID = -4454017029304697752L;

	public TransactionCostExceeded(String message){
		super(message);
	}
}
