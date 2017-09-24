package com.gs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gs.modal.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

	List<Ticket> findByTicketId(String ticketId);

}
