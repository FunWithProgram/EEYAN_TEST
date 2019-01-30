package com.eeyan.medicalstore.datatypes.order;

import java.util.List;

import com.eeyan.medicalstore.datatypes.medicine.Medicine;

import lombok.Data;

public @Data class OrderDetails {

	private List<Medicine> medicineList;
	private double price;
	private String order_id;
}
