package com.eeyan.medicalstore.rest.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.eeyan.medicalstore.datatypes.medicine.Medicine;
import com.eeyan.medicalstore.datatypes.medicine.MedicineProfilingDetails;
import com.eeyan.medicalstore.datatypes.order.OrderDetails;
import com.eeyan.medicalstore.datatypes.profile.Profile;
import com.eeyan.medicalstore.persistence.CashierPersistence;
import com.eeyan.medicalstore.persistence.SupplierPersistence;
import com.eeyan.medicalstore.persistence.UserPersistence;
import com.eeyan.medicalstore.rest.IMedicalRest;
import com.eeyan.medicalstore.service.MedService;

@Named
@Path("/eeyan.medicalstore.com")
public class MedicalRest implements IMedicalRest {
	
	@Inject
	MedService medService;

	@Override
	public Response insertOrder(OrderDetails od) {
		return Response.ok(medService.insertOrder(od)).build();
	}

	@Override
	public Response deleteOrder(String orderId) {
		return Response.ok(medService.deleteOrder(orderId)).build();
	}

	@Override
	public Response updateOrder(String orderId, OrderDetails orderDetails) {
		return Response.ok(medService.updateOrder(orderId, orderDetails)).build();
	}

	@Override
	public Response updateOrderStatus(String orderId, String status) {
		return Response.ok(medService.updateOrderStatus(orderId, status)).build();
	}

	@Override
	public Response getOrder(String id) {
		return Response.ok(medService.getOrder(id)).build();
	}

	@Override
	public Response insertCustomerDetails(UserPersistence up) {
		return Response.ok(medService.insertCustomerDetails(up)).build();
	}

	@Override
	public Response deleteCustomerDetails(String mobileNumber) {
		return Response.ok(medService.deleteCustomerDetails(mobileNumber)).build();
	}

	@Override
	public Response getCustomerDetails(String mobileNumber, String name) {
		return Response.ok(medService.getCustomerDetails(mobileNumber, name)).build();
	}

	@Override
	public Response updateCustomerDetails(Profile p, String mobileNumber) {
		return Response.ok(medService.updateCustomerDetails(p, mobileNumber)).build();
	}

	@Override
	public Response insertSupplierDetails(SupplierPersistence sp) {
		return Response.ok(medService.insertSupplierDetails(sp)).build();
	}

	@Override
	public Response deleteSupplierDetails(String mobileNumber) {
		return Response.ok(medService.deleteSupplierDetails(mobileNumber)).build();
	}

	@Override
	public Response getSupplierDetails(String mobileNumber, String name) {
		return Response.ok(medService.getSupplierDetails(mobileNumber, name)).build();
	}

	@Override
	public Response updateSupplierDetails(SupplierPersistence sp) {
		return Response.ok(medService.updateSupplierDetails(sp)).build();
	}

	@Override
	public Response insertCashierDetails(CashierPersistence cp) {
		return Response.ok(medService.insertCashierDetails(cp)).build();
	}

	@Override
	public Response deleteCashierDetails(String mobileNumber) {
		return Response.ok(medService.deleteCashierDetails(mobileNumber)).build();
	}

	@Override
	public Response getCashierDetails(String mobileNumber, String name) {
		return Response.ok(medService.getCashierDetails(mobileNumber, name)).build();
	}

	@Override
	public Response updateCashierDetails(CashierPersistence cp) {
		return Response.ok(medService.updateCashierDetails(cp)).build();
	}

	@Override
	public Response insertStock(Medicine medicine) {
		return Response.ok(medService.insertStock(medicine)).build();
	}

	@Override
	public Response updateStock(Medicine medicine, String medicineID) {
		return Response.ok(medService.updateStock(medicine, medicineID)).build();
	}

	@Override
	public Response fetchStock(String id) {
		return Response.ok(medService.fetchStock(id)).build();
	}

	@Override
	public Response deleteStock(String medicineID) {
		return Response.ok(medService.deleteStock(medicineID)).build();
	}

	@Override
	public Response fetchStock(String name, String composition) {
		return Response.ok(medService.fetchStock(name, composition)).build();
	}

	@Override
	public Response getMedicines(String mname, String composition, String popularity, String price, String brands) {
		return Response.ok(medService.getMedicines(mname, composition, popularity, price, brands)).build();
	}

	@Override
	public Response getAllSortedMedicines() {
		return Response.ok(medService.getAllSortedMedicines()).build();
	}

	@Override
	public Response getCategoryMedicines(String categoryName) {
		return Response.ok(medService.getCategoryMedicines(categoryName)).build();
	}

	@Override
	public Response fetchMedicinesDetails(String name, String composition) {
		return Response.ok(medService.fetchMedicinesDetails(name, composition)).build();
	}

	@Override
	public Response fetchMedicinesDetails(String id) {
		return Response.ok(medService.fetchMedicinesDetails(id)).build();
	}

	@Override
	public Response insertMedicineDetails(MedicineProfilingDetails mpd) {
		return Response.ok(medService.insertMedicineDetails(mpd)).build();
	}

	@Override
	public Response updateMedicineDetails(MedicineProfilingDetails mpd, String id) {
		return Response.ok(medService.updateMedicineDetails(mpd, id)).build();
	}

	@Override
	public Response deleteMedicineDetails(String id) {
		return Response.ok(medService.deleteMedicineDetails(id)).build();
	}

	@Override
	public Response fetchSellSummary(int offset) {
		return Response.ok(medService.fetchSellSummary(offset)).build();
	}

	@Override
	public Response fetchStockSummary(int offset) {
		return Response.ok(medService.fetchStockSummary(offset)).build();
	}

	@Override
	public Response fetBuyGraphData(int offset) {
		return Response.ok(medService.fetBuyGraphData(offset)).build();
	}

	@Override
	public Response fetProfitData(int offset) {
		return Response.ok(medService.fetProfitData(offset)).build();
	}

	@Override
	public Response fetTransactionData(int offset) {
		return Response.ok(medService.fetTransactionData(offset)).build();
	}
}
