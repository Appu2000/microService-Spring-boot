package com.ticket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.entity.FullTicket;
import com.ticket.entity.Ticket;
import com.ticket.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticRepo;

	public Ticket getTicket(Long cusId) {
		// TODO Auto-generated method stub
		
		System.out.println("................at service");
		
		List<Ticket> t=ticRepo.findAll();
		int n=t.size();
		
		for(int i=0 ;i<n;i++) {
			Ticket tic=t.get(i);
			  System.out.println(".............."+tic+".........."+cusId+"......"+tic.gettId());
		        if(tic.gettId().equals(cusId)) {
				    return tic;
		        }
        }
        return null;
	}

}
