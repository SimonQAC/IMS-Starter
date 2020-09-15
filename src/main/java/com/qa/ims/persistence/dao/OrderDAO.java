package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("oid");
		Long cid = resultSet.getLong("cid");
		return new Order(oid, cid);
	}

	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	//reads all from orders

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY oid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in a new database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	@Override
//	public Order create(Order order) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("INSERT INTO orders(iid, cid, quantity) values('" + order.getIid() + "', " + order.getCid() + ", " + order.getQuantity() + ")");
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}

	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders (oid, cid) values (" + order.getOid() + ", " + order.getCid() + " );");
			//statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ims`.`order" + oid + "` (`oid` INT(11) NOT NULL , `cid` INT(11) NOT NULL, FOREIGN KEY (oid) REFERENCES ims.orders (oid) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (cid) REFERENCES ims.customers (cid) ON DELETE CASCADE ON UPDATE CASCADE);");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}
	
	
	//reads individual item from database

	public Order readItem(Long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where oid = " + oid);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to
	 *                 update that order in the database
	 * @return
	 */
//	@Override
//	public Order update(Order order) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("update orders set iid ='" + order.getIid() + "', cid = '" + order.getCid() + "', quantity = '" + order.getQuantity() + "' where oid = '" + order.getOid() + "'");
//			return readItem(order.getOid());
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}

	

	

	
	
	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public int delete(long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from orders where oid = " + oid);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

}
