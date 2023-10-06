package com.aszendit.rick_and_morty.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aszendit.rick_and_morty.model.Character;
import com.aszendit.rick_and_morty.model.CharacterAppearanceResponse;
import com.aszendit.rick_and_morty.model.Episode;
import com.aszendit.rick_and_morty.model.Result;

@Service
public class CharacterServiceImpl implements CharacterService {
	
	private static final Logger logger = LogManager.getLogger(CharacterServiceImpl.class);
	
	@Autowired
	private RickAndMortyService rickAndMortyService;

	@Override
	public CharacterAppearanceResponse getCharacterAppearance(String characterName) {
		
		CharacterAppearanceResponse response = new CharacterAppearanceResponse();
		String firstAppearance = "";
		List<String> episodes = new ArrayList<>();
		
		logger.info("Obtain Character info [{}]", characterName);
		
		// Filter characters based on the provided name
		Character character = rickAndMortyService.filterCharacters(characterName);
		
		if(character != null) {
			
			// Set the character's name in the response
			response.setName(characterName);
			
			logger.info("Getting information about the episodes for character [{}]", characterName);
			
			// Iterate through character results and episodes
			for(Result result: character.getResults()) {
				for(String episodeName: result.getEpisode()) {
					
					// Get episode details from the service
					Episode episode = rickAndMortyService.getEpisodeName(episodeName);
					episodes.add(episode.getName());
					if(firstAppearance.isEmpty()) {
						firstAppearance = episode.getAirDate();
						logger.info("First appearance character in {}", firstAppearance);
					}
				}
			}
			
			response.setEpisodes(episodes);
			
			// Set episodes and convert the first appearance date format
			response.setFirstApppearance(dateStrConversor(firstAppearance));
		}else {
			logger.warn("No information about the character [{}]", characterName);
		}
			
		return response;
	}
	
	
	private String dateStrConversor(String date) {
		
        String desiredDateStr = "";

        // Define English locale for date parsing
        Locale englishLocale = new Locale("en", "US"); 
        
        // Define date formats
        SimpleDateFormat originalFormat = new SimpleDateFormat("MMMM d, yyyy", englishLocale);
        DateTimeFormatter desiredFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
        	        
            Date originalDate = originalFormat.parse(date);

            // Convert Date to LocalDate
            LocalDate localDate = originalDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

            // Format LocalDate to desired format
            desiredDateStr = localDate.format(desiredFormat);

        } catch (ParseException e) {
            logger.error("Error parsing date: " + date + " to  \"yyyy-MM-dd\" format");
            
        	// Return the original date as a fallback
            return date;
        }
        
        logger.info("Date parsed from date: {} to {}", date, desiredDateStr);

        return desiredDateStr;
    }
	

	
}
