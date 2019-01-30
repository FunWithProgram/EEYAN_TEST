package com.eeyan.medicalstore.repository;

import java.util.List;

import com.eeyan.medicalstore.datatypes.medicine.Medicine;
import com.eeyan.medicalstore.datatypes.medicine.MedicineProfilingDetails;
import com.eeyan.medicalstore.datatypes.order.DayTracker;
import com.eeyan.medicalstore.datatypes.order.OrderDetails;
import com.eeyan.medicalstore.datatypes.profile.Profile;
import com.eeyan.medicalstore.persistence.CashierPersistence;
import com.eeyan.medicalstore.persistence.MedicinePersistence;
import com.eeyan.medicalstore.persistence.OrderDetailsPersistence;
import com.eeyan.medicalstore.persistence.SupplierPersistence;
import com.eeyan.medicalstore.persistence.UserPersistence;

public interface IStoreRepo {

	/*
	 * OrderDetails
	 */
	public String insertOrder(OrderDetails od);

	public boolean deleteOrder(String orderId);

	public boolean updateOrder(String orderId, OrderDetails orderDetails);
	
	public boolean updateOrderStatus(String orderId, String status) ;
	
	public OrderDetailsPersistence getOrder(String id);

	/*
	 * customer details
	 */
	public boolean insertCustomerDetails(UserPersistence up);

	public boolean deleteCustomerDetails(String mobileNumber);
	
	public List<UserPersistence> getCustomerDetails(String mobileNumber,String name);

	public boolean updateCustomerDetails(Profile p,String number);


	/*
	 * supplier details
	 */
	public boolean insertSupplierDetails(SupplierPersistence sp);

	public boolean deleteSupplierDetails(String mobileNumber);
	
	public List<SupplierPersistence> getSupplierDetails(String mobileNumber,String name);

	public boolean updateSupplierDetails(SupplierPersistence sp);
	
	/*
	 * Cachier details
	 */
	public boolean insertCashierDetails(CashierPersistence cp);

	public boolean deleteCashierDetails(String mobileNumber);
	
	public List<CashierPersistence> getCashierDetails(String mobileNumber,String name);

	public boolean updateCashierDetails(CashierPersistence cp);

	
	/*
	 * Stock details
	 */
	public boolean insertStock(Medicine medicine);
	
	public boolean updateStock(Medicine medicine,String medicineID);
	
	public List<MedicinePersistence> fetchStock(String id);
	
	public boolean deleteStock(String medicineID);
	
	public List<MedicinePersistence> fetchStock(String name,String composition);
	
	public List<Medicine> getMedicines(String mname, String mcomposition, String popularity, String price, String brands);
	
	public List<Medicine> getAllSortedMedicines();
	
	public List<Medicine>  getCategoryMedicines(String categoryName);
	
	/*
	 * medicine details
	 */
	public List<MedicineProfilingDetails> fetchMedicinesDetails(String name,String composition);
	
	public List<MedicineProfilingDetails> fetchMedicinesDetails(String id);
	
	public boolean insertMedicineDetails(MedicineProfilingDetails mpd);
	
	public boolean updateMedicineDetails(MedicineProfilingDetails mpd,String id);
	
	public boolean deleteMedicineDetails(String id);
	
	
	/*
	 * Report
	 */
	public List<OrderDetails> fetchSellSummary(int offset);
	
	public List<Medicine> fetchStockSummary(int offset);
	
	public List<DayTracker> fetBuyGraphData(int offset);
	
	public List<DayTracker> fetProfitData(int offset);
	
	public List<DayTracker> fetTransactionData(int offset);
	
}

