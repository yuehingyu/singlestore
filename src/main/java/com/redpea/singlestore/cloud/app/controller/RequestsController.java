/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redpea.singlestore.cloud.app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redpea.singlestore.cloud.entity.Customer;

@RestController
public class RequestsController {
	
	
	@Autowired
	S2Connection S2;
	
	@Autowired
	S2ConnectionPool S2pool;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> customer_handler() throws SQLException {

		String sql = null;
		
	

		List<Customer> Customers = new ArrayList<Customer>();
		
		// get new coonection
		Statement stmt = S2.connection().createStatement();
		
		// use single store pool - there is no evidence that pool provides better performance 
		//Statement stmt = S2pool.pool().getConnection().createStatement();
		
		sql="select * from customer";

		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			
			Customer cust=new Customer();
		
			cust.setFirst_name(rs.getString("first_name"));
			cust.setLast_name(rs.getString("last_name"));
			cust.setParty_id(rs.getString("party_id"));
			cust.setTitle(rs.getString("title"));
			Customers.add(cust);
		}
		
		
		return Customers;
	}
	
	@RequestMapping(value = "/customer/pool", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> customer_handler_poll() throws SQLException {

		String sql = null;
		

		List<Customer> Customers = new ArrayList<Customer>();
		
		// get new coonection
		// Statement stmt = S2.connection().createStatement();
		
		// use single store pool - there is no evidence that pool provides better performance 
		Statement stmt = S2pool.pool().getConnection().createStatement();
		
		sql="select * from customer";

		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			
			Customer cust=new Customer();
		
			cust.setFirst_name(rs.getString("first_name"));
			cust.setLast_name(rs.getString("last_name"));
			cust.setParty_id(rs.getString("party_id"));
			cust.setTitle(rs.getString("title"));
			Customers.add(cust);
		}
		
		
		return Customers;
	}


}
