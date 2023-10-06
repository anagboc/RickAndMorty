package com.aszendit.rick_and_morty.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterAppearanceResponse {
	
	private String name;
	
	private List<String> episodes;
	
	@JsonProperty("first_apppearance")
	private String firstApppearance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<String> episodes) {
		this.episodes = episodes;
	}

	public String getFirstApppearance() {
		return firstApppearance;
	}

	public void setFirstApppearance(String first_apppearance) {
		this.firstApppearance = first_apppearance;
	}
	
	

}
