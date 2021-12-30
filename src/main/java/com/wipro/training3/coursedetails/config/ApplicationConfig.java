package com.wipro.training3.coursedetails.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    
	@Value("${jwtKey}")
	private String jwtKey;

	public String getJwtKey() {
		return jwtKey;
	}

	public void setJwtKey(String jwtKey) {
		this.jwtKey = jwtKey;
	}
	
	
}

