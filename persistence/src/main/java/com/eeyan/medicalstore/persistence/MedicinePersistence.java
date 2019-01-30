package com.eeyan.medicalstore.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eeyan.medicalstore.datatypes.medicine.Medicine;

import lombok.Data;

@Document(collection=PersistenceConstants.MONGODB_MEDICINE_COLLECTION)
public @Data class MedicinePersistence {
	private Medicine medicine;
	private String id;
}
