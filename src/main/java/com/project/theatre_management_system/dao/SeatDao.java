package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.repo.SeatRepo;

@Repository
public class SeatDao {
	
	@Autowired
	SeatRepo seatRepo;
	
	@Autowired
	TicketDao ticketDao;
	public Seat saveSeat(Seat seat) {
	return seatRepo.save(seat);
	}
	
	public Seat updateSeatById(int oldSeatId, Seat newSeat) {
		newSeat.setSeatId(oldSeatId);
//	return	seatRepo.save(newSeat);
	return	saveSeat(newSeat);
	}
	
	public Seat fetchBySeatId(int seatId) {
	   Optional<Seat> dbSeat= seatRepo.findById(seatId);
	   if(dbSeat.isPresent()) {
		   return dbSeat.get();
	   }else {
		   return null;
	   }
	}
	
	public List<Seat> fetchAllSeat(){
		return seatRepo.findAll();
	}
	
	public Seat deleteSeatById(int seatId) {
		Seat seat=fetchBySeatId(seatId);
		seatRepo.delete(seat);
		return seat;
	}
	
	public Seat addExistingTicketToExistingSeat(int ticketId,int seatId) {	      
		    Seat seat=fetchBySeatId(seatId);
		     Ticket ticket = ticketDao.fetchByTicketId(ticketId);
		      seat.setTicket(ticket);
		    return saveSeat(seat);
	     
	}
	
	public Seat addNewTicketToExistingSeat(int seatId,Ticket newTicket) {
         Seat seat=fetchBySeatId(seatId);
         seat.setTicket(newTicket);
         return saveSeat(seat);
	}

}
