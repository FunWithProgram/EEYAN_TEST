package com.eeyan.medicalstore.repository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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
import com.mongodb.BasicDBObject;

@Named
public class StoreRepository implements IStoreRepo{

	@Inject
	MongoOperations mongoOperations;

	@Override
	public OrderDetailsPersistence getOrder(String id){
		Query query = new Query().addCriteria(Criteria.where("id").is(id));
		List<OrderDetailsPersistence> olist= mongoOperations.find(query, OrderDetailsPersistence.class);
		if(olist!=null&&olist.size()>0)
			return olist.get(0);
		return null;
	}

	@Override
	public String insertOrder(OrderDetails orderDetails) {
		OrderDetailsPersistence orderDetailsPersistence=new OrderDetailsPersistence();
		orderDetailsPersistence.setOd(orderDetails);
		orderDetailsPersistence.setOrderID(String.valueOf(new Date().getTime())+orderDetails.hashCode());
		mongoOperations.save(orderDetailsPersistence);
		return orderDetailsPersistence.getOrderID();
	}

	@Override
	public boolean deleteOrder(String orderId) {
		Query query = new Query().addCriteria(Criteria.where("id").is(orderId));
		try{
			mongoOperations.remove(query, OrderDetailsPersistence.class);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOrder(String orderId, OrderDetails orderDetails) {
		OrderDetailsPersistence orderDetailsPersistence=getOrder(orderId);
		if(orderDetailsPersistence!=null){
			Query query = new Query(Criteria.where("id").is(orderId));
			BasicDBObject updateFields = new BasicDBObject();
			updateFields.append("od", orderDetails);
			BasicDBObject setQuery = new BasicDBObject();
			setQuery.append("$set", updateFields);
			Update update = Update.fromDBObject(setQuery);
			mongoOperations.upsert(query, update, OrderDetailsPersistence.class);
		}
		return false;
	}

	@Override
	public boolean updateOrderStatus(String orderId, String status) {
		try{
			OrderDetailsPersistence orderDetailsPersistence=getOrder(orderId);
			if(orderDetailsPersistence!=null){
				Query query = new Query(Criteria.where("id").is(orderId));
				BasicDBObject updateFields = new BasicDBObject();
				updateFields.append("status", status);
				BasicDBObject setQuery = new BasicDBObject();
				setQuery.append("$set", updateFields);
				Update update = Update.fromDBObject(setQuery);
				mongoOperations.upsert(query, update, OrderDetailsPersistence.class);
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean insertCustomerDetails(UserPersistence up) {
		try{
			mongoOperations.save(up);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCustomerDetails(String mobileNumber) {
		Query query = new Query().addCriteria(Criteria.where("profile.number").is(mobileNumber));
		try{
			mongoOperations.remove(query, OrderDetailsPersistence.class);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<UserPersistence> getCustomerDetails(String mobileNumber, String name) {
		Query query=null;
		if(mobileNumber!=null && name !=null)
		query = new Query().addCriteria(Criteria.where("profile.number").is(mobileNumber).and("profile.name").is(name));
		
		else if(mobileNumber!=null )
			query = new Query().addCriteria(Criteria.where("profile.number").is(mobileNumber));
		
		else 
			query = new Query().addCriteria(Criteria.where("profile.name").is(name));
		
		List<UserPersistence> result=mongoOperations.find(query, UserPersistence.class);
		
		if(result!=null && result.size()>0)
			return result;
		return null;
	}

	@Override
	public boolean updateCustomerDetails(Profile p,String number) {
		try{
		Profile profile=getCustomerDetails(number,null).get(0).getProfile();
		if(profile!=null){
			Query query = new Query(Criteria.where("profile.number").is(number));
			BasicDBObject updateFields = new BasicDBObject();
			updateFields.append("profile", p);
			BasicDBObject setQuery = new BasicDBObject();
			setQuery.append("$set", updateFields);
			Update update = Update.fromDBObject(setQuery);
			mongoOperations.upsert(query, update, UserPersistence.class);
		}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean insertSupplierDetails(SupplierPersistence sp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSupplierDetails(String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SupplierPersistence> getSupplierDetails(String mobileNumber, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSupplierDetails(SupplierPersistence sp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertCashierDetails(CashierPersistence cp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCashierDetails(String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CashierPersistence> getCashierDetails(String mobileNumber, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCashierDetails(CashierPersistence cp) {
		// TODO Auto-generated method stub
		return false;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Medicine>  getCategoryMedicines(String categoryName) {
		Query query = new Query().addCriteria(Criteria.where("mpd.categoryName").is(categoryName));
		return mongoOperations.find(query, Medicine.class);
	}

	@Override
	public List<Medicine> getAllSortedMedicines() {
		return mongoOperations.findAll( Medicine.class);
	}

	@Override
	public List<Medicine> getMedicines(String mname, String mcomposition, String popularity, String price, String brands) {

		if(mname!="" && mname!=null){
			Query query = new Query().addCriteria(Criteria.where("mpd.name").is(mname));
			return mongoOperations.find(query, Medicine.class);
		}

		if(mcomposition!="" && mcomposition!=null){
			Query query = new Query().addCriteria(Criteria.where("mpd.composition").is(mcomposition));
			return mongoOperations.find(query, Medicine.class);
		}

		if(popularity!="" && popularity!=null){
			//			Query query = new Query().addCriteria(Criteria.where("mpd.popularity").is(mcomposition));
			//			return mongoOperations.find(query, Medicine.class);
		}

		if(price!="" && price!=null){
			Query query = new Query().addCriteria(Criteria.where("mpd.sellPrice").is(price));
			return mongoOperations.find(query, Medicine.class);
		}

		if(brands!="" && brands!=null){
			Query query = new Query().addCriteria(Criteria.where("mpd.company").is(brands));
			return mongoOperations.find(query, Medicine.class);
		}
		return null;
	}

	
	@Override
	public boolean insertStock(Medicine medicine) {
		try{
			MedicinePersistence medicinePersistence=new MedicinePersistence();
			medicinePersistence.setId(String.valueOf(new Date().getTime())+medicine.hashCode());
			medicinePersistence.setMedicine(medicine);
			mongoOperations.save(medicinePersistence);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateStock(Medicine medicine,String medicineID) {
		try{
			MedicinePersistence medicinePersistence=fetchStock(medicineID).get(0);
			if(medicinePersistence!=null){
				Query query = new Query(Criteria.where("id").is(medicineID));
				BasicDBObject updateFields = new BasicDBObject();
				updateFields.append("medicine", medicine);
				BasicDBObject setQuery = new BasicDBObject();
				setQuery.append("$set", updateFields);
				Update update = Update.fromDBObject(setQuery);
				mongoOperations.upsert(query, update, MedicinePersistence.class);
			}
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public boolean deleteStock(String medicineID) {
		try{
		Query query= new Query().addCriteria(Criteria.where("id").is(medicineID));
		mongoOperations.remove(query,MedicinePersistence.class);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<MedicinePersistence> fetchStock(String name, String composition) {
		Query query=null;
		if(name !=null&&composition!=null)
			query= new Query().addCriteria(Criteria.where("medicine.mpd.name").is(name).and("medicine.mpd.composition").is(composition));
		else if(name !=null)
			query= new Query().addCriteria(Criteria.where("medicine.mpd.name").is(name));
		else
			query= new Query().addCriteria(Criteria.where("medicine.mpd.composition").is(composition));
		
		List<MedicinePersistence> result=mongoOperations.find(query, MedicinePersistence.class);
		if(result!=null && result.size()>0)
			return result;
		return null;
	}

	@Override
	public List<MedicinePersistence> fetchStock(String id) {
		Query query= new Query().addCriteria(Criteria.where("id").is(id));
		List<MedicinePersistence> result=mongoOperations.find(query, MedicinePersistence.class);
		if(result!=null && result.size()>0)
			return result;
		return null;
	}

	@Override
	public List<MedicineProfilingDetails> fetchMedicinesDetails(String id) {
		Query query= new Query().addCriteria(Criteria.where("id").is(id));
		List<MedicineProfilingDetails> result=mongoOperations.find(query, MedicineProfilingDetails.class);
		if(result!=null && result.size()>0)
			return result;
		return null;
	}
	
	@Override
	public List<MedicineProfilingDetails> fetchMedicinesDetails(String name, String composition) {
		Query query=null;
		if(name !=null&&composition!=null)
			query= new Query().addCriteria(Criteria.where("name").is(name).and("composition").is(composition));
		else if(name !=null)
			query= new Query().addCriteria(Criteria.where("name").is(name));
		else
			query= new Query().addCriteria(Criteria.where("composition").is(composition));
		
		List<MedicineProfilingDetails> result=mongoOperations.find(query, MedicineProfilingDetails.class);
		if(result!=null && result.size()>0)
			return result;
		return null;
	}

	@Override
	public boolean insertMedicineDetails(MedicineProfilingDetails mpd) {
		try{
			mpd.setId(generateID(mpd));
			mongoOperations.save(mpd);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateMedicineDetails(MedicineProfilingDetails mpd,String id) {
		try{
			MedicineProfilingDetails medicineProfilingDetails=fetchMedicinesDetails(id).get(0);
			if(medicineProfilingDetails!=null){
				Query query = new Query(Criteria.where("id").is(id));
				mongoOperations.remove(query,MedicineProfilingDetails.class);
				
				mongoOperations.save(mpd);
			}
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public boolean deleteMedicineDetails(String id) {
		try{
				Query query = new Query(Criteria.where("id").is(id));
				mongoOperations.remove(query,MedicineProfilingDetails.class);
				
			}catch(Exception e){
				return false;
			}
			return true;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<OrderDetails> fetchSellSummary(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicine> fetchStockSummary(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DayTracker> fetBuyGraphData(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<DayTracker> fetProfitData(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DayTracker> fetTransactionData(int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String generateID(Object obj){
		return String.valueOf(new Date().getTime())+obj.hashCode(); 
	}

	

}
