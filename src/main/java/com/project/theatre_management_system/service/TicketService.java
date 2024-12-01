package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.PaymentDao;
import com.project.theatre_management_system.dao.TicketDao;
import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.exception.PaymentIdNotFound;
import com.project.theatre_management_system.exception.TicketIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class TicketService {
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructureList<Ticket> responseStructureList;
	
	@Autowired 
	PaymentDao paymentDao;
	
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully data is inserted in DB");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	}
	
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket newTicket) {
		 Ticket ticket= ticketDao.fetchByTicketId(oldTicketId);
		   if(ticket !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("successfully data is updated in DB");
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return responseStructure;
		   }else {
			   throw new TicketIdNotFound();
		   }

	}
	
	public ResponseStructure<Ticket> fetchByTicketId(int ticketId) {
		   Ticket ticket= ticketDao.fetchByTicketId(ticketId);
		   if(ticket !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully data is fetched from DB");
		responseStructure.setData(ticketDao.fetchByTicketId(ticketId));
		return responseStructure;
		   }else {
			   throw new TicketIdNotFound();
		   }

	}
	
	public ResponseStructureList<Ticket> fetchAllTicket(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(ticketDao.fetchAllTicket());
		return responseStructureList;
	}
	
	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		 Ticket ticket= ticketDao.fetchByTicketId(ticketId);
		   if(ticket !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("successfully data is deleted from DB");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure;
		   }else {
			   throw new TicketIdNotFound();
		   }

	}
	
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(int paymentId,int TicketId) {
		 Ticket ticket= ticketDao.fetchByTicketId(TicketId);
		Payment payment= paymentDao.fetchByPaymentId(paymentId);
		    if(ticket !=null) {
		    	if(payment!=null) {
		    		
		    		responseStructure.setStatusCode(HttpStatus.OK.value());
		    		responseStructure.setMessage("successfully added");
		    		responseStructure.setData( ticketDao.addExistingPaymentToExistingTicket(paymentId, TicketId));
		    		return responseStructure;
		    	}else {
		    		throw new PaymentIdNotFound();
		    	}
		    }else {
		    	throw new TicketIdNotFound();		    }
	     
	}
	
	public ResponseStructure<Ticket> addNewPaymentToExistingTicket(int ticketId,Payment newPayment) {
		 Ticket ticket= ticketDao.fetchByTicketId(ticketId);
		   if(ticket !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("successfully added");
		responseStructure.setData(ticketDao.addNewPaymentToExistingTicket(ticketId, newPayment));
		return responseStructure;
	 }else {
		   throw new TicketIdNotFound();
	   }

}
}
