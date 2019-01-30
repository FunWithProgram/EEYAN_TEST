package com.eeyan.medicalstore.app.config;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;

import com.eeyan.medicalstore.rest.impl.MedicalRest;

/**
 * 
 * @author srai
 *
 */

@Named
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(MedicalRest.class);
	}
}
