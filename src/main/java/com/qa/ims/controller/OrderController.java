package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.DaoU;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderUpdateDAO;
import com.qa.ims.persistence.domain.Domain;
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
		LOGGER.info("NOTE: THIS ONLY CREATES AN EMPTY ORDER ASSOCIATED TO A CID");
		LOGGER.info("NOTE: TO ADD MULTIPLE ITEMS PLEASE UPDATE ORDER AFTER CREATION");
		LOGGER.info("Please enter a cid");
		Long cid = utils.getLong();
		Order order = orderDAO.create(new Order(cid));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 * @return 
	 */
	@Override
	public Order update() {
		UpdateAction updateAction = null;
		do {
			LOGGER.info("Which update would you like to perform?");
			UpdateAction.printUpdateActions();

			updateAction = UpdateAction.getUpdateAction(utils);

			updateAction(updateAction);

		} while (updateAction != UpdateAction.RETURN);
		return null;
	}
		
	private void updateAction(UpdateAction updateAction) {
			LOGGER.info(updateAction);
			switch (updateAction) {
			case DEL:
				LOGGER.info("test");
				break;
			case ADD:
				LOGGER.info("test");
				break;
			case IID:
				LOGGER.info("test");
				break;
			case CID:
				LOGGER.info("test");
				break;
			case QTY:
				LOGGER.info("test");
				break;
			default:
				LOGGER.info("Bad Input");
				break;
			}
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
