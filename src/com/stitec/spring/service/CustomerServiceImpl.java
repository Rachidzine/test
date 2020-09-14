package com.stitec.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stitec.spring.dao.CustomerDAO;
import com.stitec.spring.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO custmerDAO;

	@Override
	@Transactional
	public List<Customer> gerCustomers() {
		
		return custmerDAO.getCustomers();
	}

}
