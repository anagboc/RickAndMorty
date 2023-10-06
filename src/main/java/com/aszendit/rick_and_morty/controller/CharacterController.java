package com.aszendit.rick_and_morty.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aszendit.rick_and_morty.model.CharacterAppearanceResponse;
import com.aszendit.rick_and_morty.service.CharacterService;


@RestController
@RequestMapping(value = "/api/v1")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	private static final Logger logger = LogManager.getLogger(CharacterController.class);
	
	@GetMapping("/search-character-appearance")
	public ResponseEntity<CharacterAppearanceResponse> getCharacterAppearance(@RequestParam(required = true,
							            											name = "name") String name){
		
		// Call the CharacterService to get character appearance information
        // and return it as a ResponseEntity
		logger.info("GET /search-character-appearance with parameter name: {}", name);
		return ResponseEntity.ok(characterService.getCharacterAppearance(name));
	}

}
