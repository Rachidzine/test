package com.stitec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stitec.spring.dao.CustomerDAO;
import com.stitec.spring.entity.Customer;
import com.stitec.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	

	@Autowired
	CustomerService customerService;

	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> thecustomers = customerService.gerCustomers();
		
		theModel.addAttribute("customers", thecustomers);
		
				
		return "list-customers";
	}
}
