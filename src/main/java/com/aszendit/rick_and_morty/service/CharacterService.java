package com.aszendit.rick_and_morty.service;

import com.aszendit.rick_and_morty.model.CharacterAppearanceResponse;

public interface CharacterService {
	
	// Get character appearance information based on the provided character name
	public CharacterAppearanceResponse getCharacterAppearance(String characterName);

}
