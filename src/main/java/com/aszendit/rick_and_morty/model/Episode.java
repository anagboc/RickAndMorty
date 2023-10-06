package com.aszendit.rick_and_morty.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode {
	
	private int id;
	
	private String name;
	
	@JsonProperty("air_date")
	private String airDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAirDate() {
		return airDate;
	}

	public void setAirDate(String air_date) {
		this.airDate = air_date;
	}
	
	

}
