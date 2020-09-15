package com.stitec.spring.service;

import java.util.List;

import com.stitec.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> gerCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer gerCustomers(int theId);
		
	

}
