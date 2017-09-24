package com.gs.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {

	@Id
	private String id;
	
	private String name;
	
	private String address;
    
	private GeoJsonPoint location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GeoJsonPoint getLoc() {
		return location;
	}

	public void setLoc(GeoJsonPoint loc) {
		this.location = loc;
	}

	
	

}
