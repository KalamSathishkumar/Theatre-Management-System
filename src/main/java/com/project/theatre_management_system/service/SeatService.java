package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.SeatDao;
import com.project.theatre_management_system.dao.TicketDao;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.exception.SeatIdNotFound;
import com.project.theatre_management_system.exception.TicketIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class SeatService {
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	
	@Autowired
	ResponseStructureList<Seat> responseStructureList;
	
	@Autowired
	TicketDao ticketDao;
	
	public ResponseStructure<Seat> saveSeat(Seat seat) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(seatDao.saveSeat(seat));
	   return responseStructure;

	}
	
	public ResponseStructure<Seat> updateSeatById(int oldSeatId, Seat newSeat) {
		  Seat seat=seatDao.fetchBySeatId(oldSeatId);
		    if(seat !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
	   return responseStructure;
		    }else {
		    	throw new SeatIdNotFound();
		    }
	}
		    
	public ResponseStructure<Seat> fetchBySeatId(int seatId) {
	    Seat seat=seatDao.fetchBySeatId(seatId);
	    if(seat !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(seatDao.fetchBySeatId(seatId));
	   return responseStructure;
	    }else {
	    	throw new SeatIdNotFound();
	    }
	}
	
	public ResponseStructureList<Seat> fetchAllSeat(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(seatDao.fetchAllSeat());
		return responseStructureList;
	
	}
	
	public ResponseStructure<Seat> deleteSeatById(int seatId) {
		  Seat seat=seatDao.fetchBySeatId(seatId);
		    if(seat !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted from DB");
		responseStructure.setData(seatDao.deleteSeatById(seatId));
	   return responseStructure;
		    }else {
		    	throw new SeatIdNotFound();
		    }
	
	}
	
	public ResponseStructure<Seat> addExistingTicketToExistingSeat(int ticketId,int seatId) {
		  Seat seat=seatDao.fetchBySeatId(seatId);
		  Ticket ticket= ticketDao.fetchByTicketId(ticketId);
		  if(seat !=null) {
			  if(ticket !=null) {
				  
				  responseStructure.setStatusCode(HttpStatus.OK.value());
				  responseStructure.setMessage("succesfully added");
				  responseStructure.setData(seatDao.addExistingTicketToExistingSeat(ticketId, seatId));
				  return responseStructure;
			  }else {
				  throw new TicketIdNotFound();
			  }
		  }else {
			  throw new SeatIdNotFound();
		  }
     
}

public ResponseStructure<Seat> addNewTicketToExistingSeat(int seatId,Ticket newTicket) { 
	 Seat seat=seatDao.fetchBySeatId(seatId);
	 if(seat !=null) {
		 
		 responseStructure.setStatusCode(HttpStatus.OK.value());
		 responseStructure.setMessage("succesfully Added");
		 responseStructure.setData(seatDao.addNewTicketToExistingSeat(seatId, newTicket));
		 return responseStructure;
	 }else {
		 throw new SeatIdNotFound();
	 }
}

}
