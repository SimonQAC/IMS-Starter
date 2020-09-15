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
import com.qa.ims.persistence.domain.OrderUpdate;
import com.qa.ims.utils.DBUtils;

public class OrderUpdateDAO implements DaoU<OrderUpdate> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	
	@Override
	public List<OrderUpdate> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderUpdate addToOrder() {
		
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into orders (oid, iid, quantity) values (" + order.getOid() + ", " + order.getIid() + ", " + order.getQuantity() + ")");
				return readItem(order.getOid());
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
	public OrderUpdate modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
