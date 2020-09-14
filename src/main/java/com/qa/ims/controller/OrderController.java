package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("NOTE: THIS ONLY CREATES THE ORDER FOR ONE ITEM AND QUANTITY");
		LOGGER.info("NOTE: TO ADD MULTIPLE ITEMS PLEASE UPDATE ORDER AFTER CREATION");
		LOGGER.info("Please enter a cid");
		Long cid = utils.getLong();
		LOGGER.info("Please enter an iid");
		Long iid = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		Order order = orderDAO.create(new Order(iid, cid, quantity));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("WHAT WOULD YOU LIKE TO UPDATE?");
		LOGGER.info("Qty: Update Quantity");
		LOGGER.info("Cid: Update Customer ID");
		LOGGER.info("Iid: Update Item ID");
		LOGGER.info("Add: Add an item to an existing order");
		LOGGER.info("Del: Remove an item from an existing order");
		OrderUpdateController OCU = new OrderUpdateController();
		switch (utils.getString().toUpperCase()) {
		case "DEL":
			OCU.removeFromOrder();
			break;
		default:
			LOGGER.info("No match found");
			break;
		};
		return null;
		
		//old update code
		//		LOGGER.info("Please enter the oid of the order you would like to update");
//		Long oid = utils.getLong();
//		LOGGER.info("Please enter a cid");
//		Long cid = utils.getLong();
//		LOGGER.info("Please enter an iid");
//		Long iid = utils.getLong();
//		LOGGER.info("Please enter quantity");
//		Long quantity = utils.getLong();
//		Order order = orderDAO.update(new Order(oid, cid, iid, quantity));
//		LOGGER.info("Order Updated");

	}

	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the oid of the order you would like to delete");
		Long oid = utils.getLong();
		return orderDAO.delete(oid);
	}

}
