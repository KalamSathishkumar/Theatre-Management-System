package com.project.theatre_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theatre_management_system.dto.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

}
