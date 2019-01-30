package com.eeyan.medicalstore.service;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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
import com.eeyan.medicalstore.repository.IStoreRepo;
import com.eeyan.medicalstore.repository.StoreRepository;

@Named
public class MedService implements IStoreRepo {
	
	@Inject
	StoreRepository storeRepository;

	@Override
	public String insertOrder(OrderDetails od) {
		return storeRepository.insertOrder(od);
	}

	@Override
	public boolean deleteOrder(String orderId) {
		return storeRepository.deleteOrder(orderId);
	}

	@Override
	public boolean updateOrder(String orderId, OrderDetails orderDetails) {
		return storeRepository.updateOrder(orderId, orderDetails);
	}

	@Override
	public boolean updateOrderStatus(String orderId, String status) {
		return storeRepository.updateOrderStatus(orderId, status);
	}

	@Override
	public OrderDetailsPersistence getOrder(String id) {
		return storeRepository.getOrder(id);
	}

	@Override
	public boolean insertCustomerDetails(UserPersistence up) {
		return storeRepository.insertCustomerDetails(up);
	}

	@Override
	public boolean deleteCustomerDetails(String mobileNumber) {
		return storeRepository.deleteCustomerDetails(mobileNumber);
	}

	@Override
	public List<UserPersistence> getCustomerDetails(String mobileNumber, String name) {
		return storeRepository.getCustomerDetails(mobileNumber, name);
	}

	@Override
	public boolean updateCustomerDetails(Profile p, String number) {
		return storeRepository.updateCustomerDetails(p, number);
	}

	@Override
	public boolean insertSupplierDetails(SupplierPersistence sp) {
		return storeRepository.insertSupplierDetails(sp);
	}

	@Override
	public boolean deleteSupplierDetails(String mobileNumber) {
		return storeRepository.deleteSupplierDetails(mobileNumber);
	}

	@Override
	public List<SupplierPersistence> getSupplierDetails(String mobileNumber, String name) {
		return storeRepository.getSupplierDetails(mobileNumber, name);
	}

	@Override
	public boolean updateSupplierDetails(SupplierPersistence sp) {
		return storeRepository.updateSupplierDetails(sp);
	}

	@Override
	public boolean insertCashierDetails(CashierPersistence cp) {
		return storeRepository.insertCashierDetails(cp);
	}

	@Override
	public boolean deleteCashierDetails(String mobileNumber) {
		return storeRepository.deleteCashierDetails(mobileNumber);
	}

	@Override
	public List<CashierPersistence> getCashierDetails(String mobileNumber, String name) {
		return storeRepository.getCashierDetails(mobileNumber, name);
	}

	@Override
	public boolean updateCashierDetails(CashierPersistence cp) {
		return storeRepository.updateCashierDetails(cp);
	}

	@Override
	public boolean insertStock(Medicine medicine) {
		return storeRepository.insertStock(medicine);
	}

	@Override
	public boolean updateStock(Medicine medicine, String medicineID) {
		return storeRepository.updateStock(medicine, medicineID);
	}

	@Override
	public List<MedicinePersistence> fetchStock(String id) {
		return storeRepository.fetchStock(id);
	}

	@Override
	public boolean deleteStock(String medicineID) {
		return storeRepository.deleteStock(medicineID);
	}

	@Override
	public List<MedicinePersistence> fetchStock(String name, String composition) {
		return storeRepository.fetchStock(name, composition);
	}

	@Override
	public List<Medicine> getMedicines(String mname, String mcomposition, String popularity, String price,
			String brands) {
		return storeRepository.getMedicines(mname, mcomposition, popularity, price, brands);
	}

	@Override
	public List<Medicine> getAllSortedMedicines() {
		return storeRepository.getAllSortedMedicines();
	}

	@Override
	public List<Medicine> getCategoryMedicines(String categoryName) {
		return storeRepository.getCategoryMedicines(categoryName);
	}

	@Override
	public List<MedicineProfilingDetails> fetchMedicinesDetails(String name, String composition) {
		return storeRepository.fetchMedicinesDetails(name, composition);
	}

	@Override
	public List<MedicineProfilingDetails> fetchMedicinesDetails(String id) {
		return storeRepository.fetchMedicinesDetails(id);
	}

	@Override
	public boolean insertMedicineDetails(MedicineProfilingDetails mpd) {
		return storeRepository.insertMedicineDetails(mpd);
	}

	@Override
	public boolean updateMedicineDetails(MedicineProfilingDetails mpd, String id) {
		return storeRepository.updateMedicineDetails(mpd, id);
	}

	@Override
	public boolean deleteMedicineDetails(String id) {
		return storeRepository.deleteMedicineDetails(id);
	}

	@Override
	public List<OrderDetails> fetchSellSummary(int offset) {
		return storeRepository.fetchSellSummary(offset);
	}

	@Override
	public List<Medicine> fetchStockSummary(int offset) {
		return storeRepository.fetchStockSummary(offset);
	}

	@Override
	public List<DayTracker> fetBuyGraphData(int offset) {
		return storeRepository.fetBuyGraphData(offset);
	}

	@Override
	public List<DayTracker> fetProfitData(int offset) {
		return storeRepository.fetProfitData(offset);
	}

	@Override
	public List<DayTracker> fetTransactionData(int offset) {
		return storeRepository.fetTransactionData(offset);
	}
		
}
