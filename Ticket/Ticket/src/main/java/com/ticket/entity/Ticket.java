package com.ticket.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tId;
	private String Theatre;
	private String tPrice;
	private String noTicket;
	
	private Long Id;
	private Long mId;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Long tId, String theatre, String tPrice, String noTicket, Long id, Long mId) {
		super();
		this.tId = tId;
		Theatre = theatre;
		this.tPrice = tPrice;
		this.noTicket = noTicket;
		Id = id;
		this.mId = mId;
	}
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getTheatre() {
		return Theatre;
	}
	public void setTheatre(String theatre) {
		Theatre = theatre;
	}
	public String gettPrice() {
		return tPrice;
	}
	public void settPrice(String tPrice) {
		this.tPrice = tPrice;
	}
	public String getNoTicket() {
		return noTicket;
	}
	public void setNoTicket(String noTicket) {
		this.noTicket = noTicket;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getmId() {
		return mId;
	}
	public void setmId(Long mId) {
		this.mId = mId;
	}
	
}
