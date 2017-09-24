package com.gs.modal;

import java.io.Serializable;

public class LocationEntry implements Serializable {

	private static final long serialVersionUID = 2048781139233653580L;

	private String longitude;

	private String latitude;

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final String latitude) {
		this.latitude = latitude;
	}

}
