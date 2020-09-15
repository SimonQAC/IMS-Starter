package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderUpdate;
import com.qa.ims.utils.DBUtils;

public class OrderUpdateDAO implements DaoU<OrderUpdate> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderUpdate modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long iid = resultSet.getLong("iid");
		Long oid = resultSet.getLong("oid");
		Long quantity = resultSet.getLong("quantity");
		Long cid = resultSet.getLong("cid");
		return new OrderUpdate(iid, oid, quantity, cid);
	}
	@Override
	public List<OrderUpdate> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orderline");) {
			List<OrderUpdate> orderUpdates = new ArrayList<>();
			while (resultSet.next()) {
				orderUpdates.add(modelFromResultSet(resultSet));
			}
			return orderUpdates;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public OrderUpdate addToOrder(OrderUpdate orderUpdate) {
		try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into orders (oid, iid, quantity) values (" + orderUpdate.getOid() + ", " + orderUpdate.getIid() + ", " + orderUpdate.getQuantity() + ")");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
	}

	@Override
	public OrderUpdate updateRemoveFromOrder() {
		
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("DELETE FROM orders WHERE oid =" + order.getOid() + " AND iid=" + order.getIid());
				return readItem(order.getOid());
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
	}

	@Override
	public OrderUpdate updateIid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderUpdate updateCid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderUpdate updateQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public OrderUpdate readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY oid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}



}
