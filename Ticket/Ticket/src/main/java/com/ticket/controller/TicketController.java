package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
import org.springframework.web.client.RestTemplate;

import com.ticket.entity.Customer;
import com.ticket.entity.FullTicket;
import com.ticket.entity.Movie;
import com.ticket.entity.Ticket;
import com.ticket.repository.TicketRepository;
import com.ticket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticService;
	
	@Autowired
	private TicketRepository ticRepo;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<Ticket> addAll(@RequestBody Ticket tic)
	{
		return ResponseEntity.ok(((CrudRepository<Ticket, Long>) ticRepo).save(tic));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Ticket> update(@RequestBody Ticket cus) {
		return ResponseEntity.ok(((CrudRepository<Ticket, Long>) ticRepo).save(cus));
	}
	

	@RequestMapping("/{ticketId}")
    public FullTicket getContacts(@PathVariable("ticketId") Long ticketId) {
		
	    System.out.println("........................ at "+ticketId);
		FullTicket ft=new FullTicket();
		
		try {
		Ticket tic=ticService.getTicket(ticketId);
		
		ft.setTic(ticService.getTicket(ticketId));
	    System.out.println("........................ at controlend"+tic.getmId());
	    
	    Movie mov=this.restTemplate.getForObject("http://Movie/movie/"+tic.getmId(),Movie.class);
	    ft.setMov(mov);
	    
	    System.out.println("........................ at controlend"+mov);
	    
	    Customer cus=this.restTemplate.getForObject("http://Customer/customer/"+tic.getId(),Customer.class);
	    ft.setCus(cus);
	    
	    System.out.println("........................ at controlend"+cus);
		}catch(Exception e) {
			System.out.println("..........."+e);
		}

	    
        return ft;
    }

//	@GetMapping("/{userId}")
//	public User getUser1(@PathVariable("userId") Long userId) {
//		
//        User user = this.userService.getUser(userId);
//        
//        try
//        {
//	    List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);
//
//		System.out.println(contacts);
//		
//		user.setContact(contacts);
//		
//		return this.userService.getUser(userId);
//
//        }catch(Exception e) {
//        	System.out.println(e+"................................");
//        }
//		
//		return this.userService.getUser(userId);
//	}
//

}
