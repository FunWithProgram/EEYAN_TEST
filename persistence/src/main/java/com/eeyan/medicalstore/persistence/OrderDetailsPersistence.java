package com.eeyan.medicalstore.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eeyan.medicalstore.datatypes.order.OrderDetails;

import lombok.Data;
/**
 * 
 * @author srai
 *
 */
@Document(collection=PersistenceConstants.MONGODB_ORDER_COLLECTION)
public @Data class OrderDetailsPersistence {
      private OrderDetails od;
      private String status;
      private String orderID;
}
