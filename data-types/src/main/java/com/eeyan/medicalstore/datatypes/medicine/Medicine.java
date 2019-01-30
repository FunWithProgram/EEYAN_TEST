package com.eeyan.medicalstore.datatypes.medicine;

import java.util.Date;

import lombok.Data;

public @Data class Medicine {

	private MedicineProfilingDetails mpd;
	private Date expiryDate;
	private double bugPrice;
	private double sellPrice;
	private int quantity;
}
