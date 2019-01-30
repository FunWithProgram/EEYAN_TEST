package com.eeyan.medicalstore.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eeyan.medicalstore.datatypes.medicine.MedicineProfilingDetails;

import lombok.Data;
/**
 * 
 * @author srai
 *
 */
@Document(collection=PersistenceConstants.MONGODB_MEDICINE_DETAILS_COLLECTION)
public @Data class MedicalDetailsPersistence {
 
	private MedicineProfilingDetails md;
	
}