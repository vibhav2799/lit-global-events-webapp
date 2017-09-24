package com.gs.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gs.modal.Event;
import com.gs.modal.EventDAO;
import com.gs.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {
	
	

	@Autowired
	private EventRepository eventRepository;

	@RequestMapping("/all")
	public String greeting() {
		return "Server is running!!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location")
	public final List<EventDAO> getLocations(@RequestParam("lat") String latitude,
			@RequestParam("long") String longitude, @RequestParam("d") double distance) {

		List<Event> events = this.eventRepository.findByLocationNear(
				new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
				new Distance(distance, Metrics.KILOMETERS));
		List<EventDAO> daoList = new ArrayList<EventDAO>();
		for (Event event : events) {
			EventDAO dao = new EventDAO();
			dao.setName(event.getName());
			dao.setLatitude(event.getLoc().getX());
			dao.setLongitude(event.getLoc().getY());
			dao.setAddress(event.getAddress());
			daoList.add(dao);
		}
		return daoList;
	}

}
