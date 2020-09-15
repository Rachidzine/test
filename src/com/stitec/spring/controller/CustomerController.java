package com.stitec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustumer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCostomer = customerService.gerCustomers(theId);
		
		theModel.addAttribute("customer", theCostomer);
		
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
	
	
	
}
