package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Customer;
import com.crud.repository.CruRepository;


@Service
public class CrudService {
	@Autowired
	private CruRepository cruRepository;

	public void addCustomer(Customer newCustomer) {
		cruRepository.save(newCustomer);
		
	}

	public Iterable<Customer> getAllCustomers() {
		return cruRepository.findAll();
		
	}

	public void deleteCustomer(Integer id) {
		cruRepository.deleteById(id);
	}

	public Customer getCustomerById(Integer id) {
		return cruRepository.findById(id).get();
	}
	
	public void updateTask(Integer id, Customer updateTask) {
		updateTask.setId(id);
		this.cruRepository.save(updateTask);
	}

}
