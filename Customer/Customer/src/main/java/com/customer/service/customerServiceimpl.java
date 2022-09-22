package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.customerRepository;

@Service
public class customerServiceimpl implements customerService{
	
	@Autowired
	private customerRepository cusRepo;
	

	public Customer getCus(Long id) {
		// TODO Auto-generated method stub
		
		List<Customer> cus=cusRepo.findAll();
		int n=cus.size();
		for(int i=0;i<n;i++) {
			Customer c=cus.get(i);
			if(c.getId().equals(id)) {
				
				return c;
			}
			
		}
		
		
		return null;
	}
	

}
