package com.eeyan.medicalstore.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eeyan.medicalstore.datatypes.profile.Profile;

import lombok.Data;
/**
 * 
 * @author srai
 *
 */
@Document(collection=PersistenceConstants.MONGODB_CASHIER_COLLECTION)
public @Data class CashierPersistence {
 
	private Profile profile;
	private String adhaarNumber;
	
}