package com.gs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.gs.modal.Event;
import com.gs.modal.Ticket;
import com.gs.repository.EventRepository;
import com.gs.repository.TicketRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {

		eventRepository.deleteAll();
		Event e = new Event();
		e.setName("Aditya");
		e.setLoc(new GeoJsonPoint(Double.valueOf("-73.965355"), Double.valueOf("40.782865")));
		e.setAddress("Chicago");
		eventRepository.save(e);
		
		Event e1 = new Event();
		e1.setName("Ullas");
		e1.setLoc(new GeoJsonPoint(Double.valueOf("-73.965355"), Double.valueOf("40.782865")));
		e1.setAddress("Chicago");
		eventRepository.save(e1);
		

		ticketRepository.deleteAll();
		Ticket t = new Ticket();
		t.setName("Aditya");
		t.setBelongTo("ACM");
		t.setTicketId("18739742943729472398");
		t.setValid(true);
		ticketRepository.save(t);

	}
}
