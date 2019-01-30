package com.eeyan.medicalstore.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eeyan.medicalstore.datatypes.profile.Profile;

import lombok.Data;
/**
 * 
 * @author srai
 *
 */
@Document(collection=PersistenceConstants.MONGODB_USER_COLLECTION)
public @Data class UserPersistence {
 
	private Profile profile;
	
}