package com.eeyan.medicalstore.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

public interface IMedicalRest {
	//category - stamtch, headache etc... 
	//all medicine in alphabetic
	//all list based name n composition - popularity, price, brand [filter]
	//medicine details
	//order place/image
	//order update
	//order using receipt

	//	@GET
	//	@Path("/medicine/category/{categoryName}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response getCategoryMedicines(@PathParam("categoryName") String categoryName);
	//	
	//	@GET
	//	@Path("/medicine/allmedicines")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response getAllSortedMedicines();
	//	
	//	@GET
	//	@Path("/medicine/search/{mname}/{mcomposition}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response getMedicines(@PathParam("mname") String mname,@PathParam("mcomposition") String mcomposition,
	//			@QueryParam("popularity") String popularity, @QueryParam("price") String price,
	//			@QueryParam("brand") String brands);
	//	
	//	@GET
	//	@Path("/medicine/getDetails/{id}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response getMedicineDetails(@PathParam("id") String id);
	//	
	//	@POST
	//	@Path("/order/place")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response placeOrder(OrderDetails orderDetails);
	//	
	//	@POST
	//	@Path("/order/update/status/{orderId}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response updateOrderStatus(@PathParam("orderId") String orderId,String status);
	//	
	//	@POST
	//	@Path("/order/update/{orderId}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response updateOrder(@PathParam("orderId") String orderId,OrderDetails orderDetails);


	//////////////////////////////////////////////Storage
	//	@POST
	//	@Path("/medicine/add")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response storeMedicine(Medicine medicine);
	//	
	//	@GET
	//	@Path("/medicine/remove/{id}")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response removeMedicine(@PathParam("id") String id);
	//	
	//******************************************************************************************************************//
	@POST
	@Path("/order/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOrder(OrderDetails od);


	@GET
	@Path("/order/delete/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOrder(@PathParam("orderId") String orderId);


	@POST
	@Path("/order/update/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(@PathParam("orderId") String orderId, OrderDetails orderDetails);


	@GET
	@Path("/order/update/status/{orderId}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrderStatus(@PathParam("orderId") String orderId, @PathParam("status") String status) ;

	@GET
	@Path("/order/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("orderId")  String id);

	/*
	 * customer details
	 */


	@POST
	@Path("/customer/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCustomerDetails(UserPersistence up);

	@GET
	@Path("/customer/delete/{mobileNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCustomerDetails(@PathParam("mobileNumber") String mobileNumber);

	@POST
	@Path("/customer/{mobileNumber}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCustomerDetails(@PathParam("mobileNumber") String mobileNumber, @PathParam("name") String name);

	@POST
	@Path("/customer/update/{mobileNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomerDetails(Profile p,@PathParam("mobileNumber") String mobileNumber);


	/*
	 * supplier details
	 */
	
	@POST
	@Path("/supplier/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertSupplierDetails(SupplierPersistence sp);

	@GET
	@Path("/customer/delete/{mobileNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSupplierDetails(@PathParam("mobileNumber") String mobileNumber);

	@GET
	@Path("/customer/delete/{mobileNumber}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSupplierDetails(@PathParam("mobileNumber") String mobileNumber, @PathParam("name") String name);

	@POST
	@Path("/supplier/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSupplierDetails(SupplierPersistence sp);

	/*
	 * Cachier details
	 */
	
	@POST
	@Path("/cashier/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCashierDetails(CashierPersistence cp);

	@GET
	@Path("/cashier/delete/{mobileNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCashierDetails(@PathParam("mobileNumber") String mobileNumber);

	
	@GET
	@Path("/cashier/{mobileNumber}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCashierDetails(@PathParam("mobileNumber") String mobileNumber, @PathParam("name") String name);

	@POST
	@Path("/cashier/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCashierDetails(CashierPersistence cp);


	/*
	 * Stock details
	 */
	
	@POST
	@Path("/stock/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStock(Medicine medicine);

	@POST
	@Path("/stock/update/{medicineID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStock(Medicine medicine, @PathParam("medicineID") String medicineID);

	@GET
	@Path("/stock/{medicineID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchStock(@PathParam("medicineID") String id);

	@GET
	@Path("/stock/delete/{medicineID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStock(@PathParam("medicineID") String medicineID);

	@GET
	@Path("/stock/{name}/{composition}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchStock(@PathParam("name") String name, @PathParam("composition") String composition);

	@GET
	@Path("/stock/filter/{mname}/{mcomposition}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMedicines(@PathParam("mname") String mname,@PathParam("composition") String composition,
						@QueryParam("popularity") String popularity, @QueryParam("price") String price,
						@QueryParam("brand") String brands);

	@GET
	@Path("/stock/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllSortedMedicines();

	@GET
	@Path("/stock/category/{categoryName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  getCategoryMedicines(@PathParam("categoryName") String categoryName);

	/*
	 * medicine details
	 */
	
	@GET
	@Path("/medicine/details/{name}/{composition}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchMedicinesDetails(@PathParam("name") String name, @PathParam("composition") String composition);

	@GET
	@Path("/medicine/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchMedicinesDetails(@PathParam("name") String id);

	@POST
	@Path("/medicine/details/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMedicineDetails(MedicineProfilingDetails mpd);

	@POST
	@Path("/medicine/details/insert/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMedicineDetails(MedicineProfilingDetails mpd,@PathParam("id") String id);

	@GET
	@Path("/medicine/details/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMedicineDetails(@PathParam("id") String id);


	/*
	 * Report
	 */
	
	@GET
	@Path("/report/sellsummary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchSellSummary(@PathParam("id") int offset);

	@GET
	@Path("/report/stocksummary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchStockSummary(@PathParam("id") int offset);

	@GET
	@Path("/report/buydata/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetBuyGraphData(@PathParam("id") int offset);

	@GET
	@Path("/report/profitdata/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetProfitData(@PathParam("id") int offset);

	@GET
	@Path("/report/transactiondata/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetTransactionData(@PathParam("id") int offset);




	//*******************************************************************************************************************//

}
