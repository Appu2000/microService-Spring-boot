package com.ticket.entity;

public class FullTicket {

	
	private Ticket tic=new Ticket();
	private Customer cus=new Customer();
	private Movie mov=new Movie();
	
	public FullTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullTicket(Ticket tic, Customer cus, Movie mov) {
		super();
		this.tic = tic;
		this.cus = cus;
		this.mov = mov;
	}

	public FullTicket(Ticket tic, Customer cus) {
		super();
		this.tic = tic;
		this.cus = cus;
	}

	public FullTicket(Ticket tic, Movie mov) {
		super();
		this.tic = tic;
		this.mov = mov;
	}

	public Ticket getTic() {
		return tic;
	}

	public void setTic(Ticket tic) {
		this.tic = tic;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	public Movie getMov() {
		return mov;
	}

	public void setMov(Movie mov) {
		this.mov = mov;
	}

	
}
