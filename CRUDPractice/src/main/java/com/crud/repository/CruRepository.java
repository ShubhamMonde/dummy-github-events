package com.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.model.Customer;

public interface CruRepository extends CrudRepository<Customer, Integer>{
	
}
