package com.aszendit.rick_and_morty.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aszendit.rick_and_morty.config.ApplicationConfiguration;
import com.aszendit.rick_and_morty.exception.RickAndMortyApiException;
import com.aszendit.rick_and_morty.model.Character;
import com.aszendit.rick_and_morty.model.Episode;

@Service
public class RickAndMortyServiceImpl implements RickAndMortyService{

	private static final Logger logger = LogManager.getLogger(RickAndMortyServiceImpl.class);
	
	@Autowired
	ApplicationConfiguration appConfig;
	
	@Autowired
    private HttpHeaders httpHeaders;
	
	@Autowired
    private RestTemplate restTemplate;
	
	// Filter characters based on the provided key
	@Override
	public Character filterCharacters(String key) {
		
		logger.info("RickAndMortyServiceImpl.filterCharacters([])", key);
		
		String lsUrl = appConfig.getProperty("rickandmorty.url-base") + "character/?name=" + key;
		
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        
        try {
        	ResponseEntity<Character> response = restTemplate.exchange(lsUrl, HttpMethod.GET,
                    entity, Character.class);
        	
        	return response.getBody();
        	
        }catch (Exception e) {
        	logger.error("Error in RickAndMortyServiceImpl.filterCharacters "+ e.getMessage());
        	throw new RickAndMortyApiException("MessageError: " + e.getMessage());       	
		}  
        
	}

	
	// Get episode details based on the provided URL
	@Override
	public Episode getEpisodeName(String url) {
			
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {
        	ResponseEntity<Episode> response = restTemplate.exchange(url, HttpMethod.GET,
                    entity, Episode.class);
            
            return response.getBody();
        }catch (Exception e) {
        	logger.error("Error in RickAndMortyServiceImpl.getEpisodeName(): "+ e.getMessage());
        	throw new RickAndMortyApiException("MessageError: " + e.getMessage());
		} 
	}
	
}
