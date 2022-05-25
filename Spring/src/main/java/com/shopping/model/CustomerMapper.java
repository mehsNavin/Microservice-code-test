package com.shopping.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<CustomerResponse> {
	CustomerResponse cusResponse = new CustomerResponse();
	public CustomerResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
	   
		cusResponse.setCustomerID(rs.getString("CUSTOMERID"));
		cusResponse.addProducts(rs.getString("PRODUCTCODE"));
		cusResponse.addTotalCost(rs.getLong("TOTAL_COST"));
	    return cusResponse;
	   }
	}