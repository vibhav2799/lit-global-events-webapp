package com.gs.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gs.modal.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

	List<Event> findByLocationNear(Point p, Distance d);

}
