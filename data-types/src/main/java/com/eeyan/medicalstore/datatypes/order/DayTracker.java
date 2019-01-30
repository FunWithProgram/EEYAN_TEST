package com.eeyan.medicalstore.datatypes.order;

import java.util.Date;

import lombok.Data;

public @Data class DayTracker {

	private Date date;
	private String transactionAmt;
	private String profit;
}
