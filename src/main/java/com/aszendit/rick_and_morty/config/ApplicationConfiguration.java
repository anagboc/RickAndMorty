package com.aszendit.rick_and_morty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@Configuration
@PropertySource("application.properties")
public class ApplicationConfiguration {
    
	@Autowired
    private Environment env;
	
	// Retrieve a property value from the environment
	public String getProperty(String pPropertyKey) {
		return env.getProperty(pPropertyKey);
	}
	
	// Create a RestTemplate bean
	@Bean
	public RestTemplate restTemplate() {
	  return new RestTemplate();
	}

	// Create HttpHeaders bean
	@Bean
	public HttpHeaders httpHeaders() {
	  return new HttpHeaders();
	}
	
}