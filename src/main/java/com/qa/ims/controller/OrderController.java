package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.Dao;
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
//	@Override
//	public List<Order> readAll() {
//		List<Order> orders = orderDAO.readAll();
//		for (Order order : orders) {
//			LOGGER.info(order.toString());
//		}
//		return orders;
//	}

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

			updateAction(null, updateAction);

		} while (updateAction != UpdateAction.RETURN);
		return null;
	}
		
	private Order updateAction(Dao<?> Dao, UpdateAction updateAction) {
			LOGGER.info(updateAction);
			switch (updateAction) {
			case DEL:
				LOGGER.info("Please enter oid to delete from");
				Long oid = utils.getLong();
				LOGGER.info("Please enter iid to delete from order");
				Long iid = utils.getLong();
				Order order = orderDAO.updateRemoveFromOrder(new Order(oid,iid));
				LOGGER.info("Item removed from order");
				return order;
			case ADD:
				LOGGER.info("Please enter an oid to update");
				Long oid2 = utils.getLong();
				LOGGER.info("Please enter an iid to add to the order");
				Long iid2 = utils.getLong();
				LOGGER.info("Please enter a quantity to add to the order");
				Long quantity2 = utils.getLong();
				Order order2 = orderDAO.addToOrder(new Order(oid2, iid2, quantity2));
				LOGGER.info("Item added to order");
				return order2;
			case RETURN:
				return null;
			default:
				LOGGER.info("Bad Input");
				return null;
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

	@Override
	public List<Order> readAll() {
		ReadAction readAction = null;
		do {
			LOGGER.info("Which read operation would you like to perform?");
			ReadAction.printReadActions();

			readAction = ReadAction.getReadAction(utils);

			readAction(null, readAction);

		} while (readAction != ReadAction.RETURN);
		return null;
	}
	
	private Order readAction(Dao<?> Dao, ReadAction readAction) {
		LOGGER.info(readAction);
		switch (readAction) {
		case ALL:
			return null;
		case ORDER:
			return null;
		case RETURN:
			return null;
		default:
			LOGGER.info("Bad Input");
			return null;
		}
	}

}
