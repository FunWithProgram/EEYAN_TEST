package com.eeyan.medicalstore.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * 
 * @author srai
 *
 */
@SpringBootApplication
@ComponentScan("com.eeyan.medicalstore")
@EnableAsync
@EnableMongoRepositories("com.eeyan.medicalstore")
public class MedicalstoreApp 
{
	public static void main(String[] args) {
		SpringApplication.run(MedicalstoreApp.class, args);
	}
}