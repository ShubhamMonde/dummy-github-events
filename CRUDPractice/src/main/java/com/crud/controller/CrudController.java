package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.model.Customer;
import com.crud.service.CrudService;

@Controller
public class CrudController {
	@Autowired
	private CrudService crudService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("customers",crudService.getAllCustomers());
		return "home.html";
	}
	
	@GetMapping("/addcustomer")
	public String addCustomer(Model model) {
		Customer newCustomer=new Customer();
		model.addAttribute("newCustomer",newCustomer);
		return "addCustomer.html";
		
	}
	
	@PostMapping("/addcustomer")
	public String addCustomer(@ModelAttribute Customer newCustomer) {
		crudService.addCustomer(newCustomer);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam Integer id) {
		crudService.deleteCustomer(id);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateCustomer(@PathVariable Integer id, Model model) {
		//we have to search that id
		Customer foundCustomer=this.crudService.getCustomerById(id);
		model.addAttribute("foundCustomer",foundCustomer);
		return "update.html";
	}
	
	@PostMapping("/update/{id}")
	public String updateCustomer(@PathVariable Integer id, @ModelAttribute Customer updateTask) {//Object come filled from request so extract these we use @ModelAttribute
		this.crudService.updateTask(id,updateTask);
		return "redirect:/";
		
	}
	

}
