package com.gs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gs.modal.Ticket;
import com.gs.repository.TicketRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
	public final List<Ticket> getLocations(@PathVariable("ticketId") String ticketId) {
		return this.ticketRepository.findByTicketId(ticketId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{ticketId}/invalidate")
	public final void invalidate(@PathVariable("ticketId") String ticketId) {
		List<Ticket> tickets = this.ticketRepository.findByTicketId(ticketId);
		if (tickets != null && tickets.size() > 0) {
			Ticket t = tickets.get(0);
			t.setValid(false);
			this.ticketRepository.save(t);
		}
	}

}
