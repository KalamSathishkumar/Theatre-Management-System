package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.repo.TicketRepo;

@Repository
public class TicketDao {
	
	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	PaymentDao paymentDao;
	
	public Ticket saveTicket(Ticket ticket) {
	return ticketRepo.save(ticket);
	}
	
	public Ticket updateTicketById(int oldTicketId, Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
//	return	ticketRepo.save(newTicket);
	return	saveTicket(newTicket);
	}
	
	public Ticket fetchByTicketId(int ticketId) {
	  Optional<Ticket> dbTicket= ticketRepo.findById(ticketId);
	  if(dbTicket.isPresent()) {
		  return dbTicket.get();
	  }else{
		  return null;
	  }
	}
	
	public List<Ticket> fetchAllTicket(){
		return ticketRepo.findAll();
	}
	
	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket=fetchByTicketId(ticketId);
		ticketRepo.delete(ticket);
		return ticket;
	}
	
	public Ticket addExistingPaymentToExistingTicket(int paymentId,int TicketId) {	      
		 Ticket ticket=fetchByTicketId(TicketId);
		 Payment payment=paymentDao.fetchByPaymentId(paymentId);		 
		 ticket.setPayment(payment);
		 return saveTicket(ticket);
	     
	}
	
	public Ticket addNewPaymentToExistingTicket(int ticketId,Payment newPayment) {
         Ticket ticket=fetchByTicketId(ticketId);
         ticket.setPayment(newPayment);        
         return saveTicket(ticket);
	}
	

}
