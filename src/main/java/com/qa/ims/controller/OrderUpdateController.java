//package com.qa.ims.controller;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.qa.ims.persistence.dao.DaoU;
//import com.qa.ims.persistence.dao.OrderUpdateDAO;
//import com.qa.ims.persistence.domain.OrderUpdate;
//import com.qa.ims.utils.Utils;
//
//public class OrderUpdateController implements DaoU<OrderUpdate>{
//	
//	public static final Logger LOGGER = LogManager.getLogger();
//	
//	private OrderUpdateDAO orderUpdateDAO;
//	private Utils utils;
//	
//	public OrderUpdateController(OrderUpdateDAO orderUpdateDao, Utils utils, OrderUpdateDAO orderUpdateDAO) {
//		super();
//		this.orderUpdateDAO = orderUpdateDAO;
//		this.utils = utils;
//	}
//
//	public OrderUpdate modelFromResultSet(ResultSet resultSet) throws SQLException {
//
//		return null;
//	}
//
//	public List<OrderUpdate> readAll() {
//
//		return null;
//	}
//	public OrderUpdate addToOrder() {
//		LOGGER.info("Please enter an oid to update");
//		Long oid = utils.getLong();
//		LOGGER.info("Please enter an iid to add to the order");
//		Long iid = utils.getLong();
//		LOGGER.info("Please enter a quantity to add to the order");
//		Long quantity = utils.getLong();
//		OrderUpdate orderUpdate = orderUpdateDAO.addToOrder(new OrderUpdate(oid, iid, quantity));
//		LOGGER.info("Item added to order");
//		return orderUpdate;
//	}
//
//	public OrderUpdate updateRemoveFromOrder() {
//		LOGGER.info("Please enter an order id to update");
//		Long oid = utils.getLong();
//		LOGGER.info("Please enter an iid to remove from the order");
//		Long iid = utils.getLong();
//		OrderUpdate orderUpdate = orderUpdateDAO.updateRemoveFromOrder(new OrderUpdate(oid, iid));
//		LOGGER.info("Item removed");
//		return orderUpdate;
//	}
//
//	public OrderUpdate updateIid() {
//		LOGGER.info("Please enter an oid to update");
//		Long oid = utils.getLong();
//		LOGGER.info("Please enter an iid to replace");
//		Long iid = utils.getLong();
//		OrderUpdate orderUpdate = orderUpdateDAO.updateIid(new OrderUpdate(oid, iid));
//		return orderUpdate;
//	}
//
//	public OrderUpdate updateCid() {
//		LOGGER.info("You shouldn't be seeing this, Simon you should probabaly delete all the code that points here");
//		return null;
//	}
//
//	public OrderUpdate updateQuantity() {
//		LOGGER.info("Please enter an oid to update");
//		Long oid = utils.getLong();
//		LOGGER.info("Please eneter the new quantity");
//		Long quantity = utils.getLong();
//		OrderUpdate orderUpdate = orderUpdateDAO.updateQuantity(new OrderUpdate(oid, quantity));
//		return orderUpdate;
//	}
//
//	public OrderUpdate readLatest() {
//
//		return null;
//	}
//
//	
//
//}
