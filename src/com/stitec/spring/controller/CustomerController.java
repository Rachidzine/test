package com.stitec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stitec.spring.dao.CustomerDAO;
import com.stitec.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> thecustomers = customerDAO.getCustomers();
		
		theModel.addAttribute("customers", thecustomers);
		
		
		
		return "list-customers";
	}
}
