package com.eeyan.medicalstore.app.config;

import javax.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author srai
 * 
 * This class is to configure the project dependencies
 *
 */

@Named
public class AppConfig {
	@Bean
	public RestTemplate restCreation() {
		return new RestTemplate();
	} 
}
