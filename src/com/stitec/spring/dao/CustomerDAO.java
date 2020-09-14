package com.stitec.spring.dao;

import java.util.List;

import com.stitec.spring.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
