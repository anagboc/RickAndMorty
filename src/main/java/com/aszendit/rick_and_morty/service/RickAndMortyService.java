package com.aszendit.rick_and_morty.service;

import com.aszendit.rick_and_morty.model.Character;
import com.aszendit.rick_and_morty.model.Episode;

public interface RickAndMortyService {
	
	// Filter characters based on the provided key
	public Character filterCharacters(String key);
	
	// Get episode details based on the provided URL
	public Episode getEpisodeName(String url);

}
