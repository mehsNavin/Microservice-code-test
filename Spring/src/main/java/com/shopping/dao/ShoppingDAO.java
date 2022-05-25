package com.shopping.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shopping.exception.handler.InactiveProduct;
import com.shopping.exception.handler.TransactionCostExceeded;
import com.shopping.model.CustomerMapper;
import com.shopping.model.CustomerResponse;
import com.shopping.model.Transaction;

@Repository
public class ShoppingDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String addTransaction(Transaction transaction){
		if(!isProductActive(transaction.getProductCode())){
			throw new InactiveProduct("Product "+transaction.getProductCode()+" not Active");
		}
		if(isTotalCostGreaterThan5000(transaction.getProductCode(),transaction.getQuantity())){
			throw new TransactionCostExceeded("Transaction Cost is > 5000");
		}
		jdbcTemplate.update("INSERT INTO Transactions (Transaction_Time,CustomerID,Quantity,Product_Code) "
				+ "VALUES (?, ?, ?, ?)", transaction.getDate(), transaction.getCustomerID(), 
				transaction.getQuantity(), transaction.getProductCode());
		
		return "Data Inserted Successfully";

	}
	
	
	private boolean isProductActive(String productCode){
		
		String sql = "SELECT STATUS FROM PRODUCT WHERE PRODUCT_CODE = '"+productCode+"'";

		List<String> status = jdbcTemplate.query(sql,(rs, rowNum) ->
                rs.getString("STATUS")
        );
		status.removeAll(Collections.singleton(null));
        return !status.isEmpty()&&status.get(0).equalsIgnoreCase("Active");
	}
	
	private boolean isTotalCostGreaterThan5000(String productCode,Integer quantity){
		
		String sql = "SELECT COST FROM PRODUCT WHERE PRODUCT_CODE = '"+productCode+"'";

		List<Integer> cost = jdbcTemplate.query(sql,(rs, rowNum) ->
                rs.getInt("COST")
        );
		cost.removeAll(Collections.singleton(null));
		System.out.println(cost.get(0)*quantity);
        return !cost.isEmpty()&&cost.get(0)*quantity>5000;
	}

	public CustomerResponse getCustomerCost(String customerId){
		CustomerMapper cusMapper = new CustomerMapper();
		String sql = "SELECT  T.CUSTOMERID as CUSTOMERID, P.PRODUCT_CODE AS PRODUCTCODE, SUM(T.QUANTITY*P.COST) AS TOTAL_COST "
				+ "from TRANSACTIONS T inner join PRODUCT P ON T.PRODUCT_CODE = P.PRODUCT_CODE where "
				+ "T.CUSTOMERID ='"+customerId+"' GROUP BY P.PRODUCT_CODE";
		System.out.println(sql);
		List<CustomerResponse> cost = jdbcTemplate.query(sql,cusMapper);
		System.out.println(cost);
		cost.removeAll(Collections.singleton(null));
		return !cost.isEmpty()?cost.get(0):new CustomerResponse();
	}

	public String getProductCost(String productId){

		String sql = "SELECT  SUM(T.QUANTITY*P.COST) AS TOTAL_COST "
				+ "from TRANSACTIONS T inner join PRODUCT P ON T.PRODUCT_CODE = P.PRODUCT_CODE where T.PRODUCT_CODE='"+productId+"'";
		System.out.println(sql);
		List<String> cost = jdbcTemplate.query(sql,(rs, rowNum) ->rs.getString("TOTAL_COST"));
		System.out.println(cost);
		cost.removeAll(Collections.singleton(null));
		return !cost.isEmpty()?cost.get(0):"Product Not Found";
		
	}

	public String getTransactionsByLocation(String location){

		String sql = "SELECT  Count(*) AS TOTAL_TRANSACTIONS "
				+ "from TRANSACTIONS T inner join CUSTOMER C ON T.CUSTOMERID= C.CUSTOMER_ID where C.LOCATION ='"+location+"'";
		System.out.println(sql);
		List<String> cost = jdbcTemplate.query(sql,(rs, rowNum) ->rs.getString("TOTAL_TRANSACTIONS"));
		System.out.println(cost);
		cost.removeAll(Collections.singleton(null));
		return !cost.isEmpty()?cost.get(0):"Location Not Found";
		
	}

}
