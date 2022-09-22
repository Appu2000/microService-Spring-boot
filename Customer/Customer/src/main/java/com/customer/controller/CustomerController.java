package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.repository.customerRepository;
import com.customer.service.customerService;




@RestController
@RequestMapping("/customer")

public class CustomerController {
	
	@Autowired
	private customerRepository cusRepo;
	
	@Autowired
	private customerService cusSer;

	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addAll(@RequestBody Customer cus)
	{
		return ResponseEntity.ok(((CrudRepository<Customer, Long>) cusRepo).save(cus));
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(cusRepo.findAll());
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		return ResponseEntity.ok(cusRepo.findById(id).orElse(null));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> update(@RequestBody Customer cus) {
		return ResponseEntity.ok(cusRepo.save(cus));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> delete(@PathVariable Long id) {
		cusRepo.findById(id).ifPresent(cusRepo::delete);
		return ResponseEntity.ok().build();
	}

	
//	@RequestMapping("/{id}")
//	public Movie get(@PathVariable("id") Long mId) {
//		
//		Movie mov=new Movie();
//		mov=movSer.getMovie(mId);
//		System.out.println(".............."+mov);
//		return mov;
//		
//	}
	
	@RequestMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") Long Id) {
		
		Customer cus=new Customer();
		cus=cusSer.getCus(Id);
		return cus;
		
	}
	


}
