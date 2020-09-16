//package com.qa.ims.persistence.dao;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.qa.ims.persistence.domain.OrderUpdate;
//import com.qa.ims.utils.DBUtils;
//
//public class OrderUpdateDAO implements DaoU<OrderUpdate> {
//	
//	public static final Logger LOGGER = LogManager.getLogger();
//
//	public OrderUpdate modelFromResultSet(ResultSet resultSet) throws SQLException {
//		Long iid = resultSet.getLong("iid");
//		Long oid = resultSet.getLong("oid");
//		Long quantity = resultSet.getLong("quantity");
//		return new OrderUpdate(iid, oid, quantity);
//	}
//	public List<OrderUpdate> readAll() {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("select * from orderline");) {
//			List<OrderUpdate> orderUpdates = new ArrayList<>();
//			while (resultSet.next()) {
//				orderUpdates.add(modelFromResultSet(resultSet));
//			}
//			return orderUpdates;
//		} catch (SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return new ArrayList<>();
//	}
//
//	public OrderUpdate addToOrder(OrderUpdate orderUpdate) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//					Statement statement = connection.createStatement();) {
//				statement.executeUpdate("insert into orderline (oid, iid, quantity) values (" + orderUpdate.getOid() + ", " + orderUpdate.getIid() + ", " + orderUpdate.getQuantity() + ")");
//				return readLatest();
//			} catch (Exception e) {
//				LOGGER.debug(e);
//				LOGGER.error(e.getMessage());
//			}
//			return null;
//	}
//
//	public OrderUpdate updateRemoveFromOrder(OrderUpdate orderUpdate) {
//	
//			try (Connection connection = DBUtils.getInstance().getConnection();
//					Statement statement = connection.createStatement();) {
//				statement.executeUpdate("DELETE FROM orderline WHERE oid =" + orderUpdate.getOid() + " AND iid=" + orderUpdate.getIid());
//				return readLatest();
//			} catch (Exception e) {
//				LOGGER.debug(e);
//				LOGGER.error(e.getMessage());
//			}
//			return null;
//	}
//
//	public OrderUpdate updateIid(OrderUpdate orderUpdate) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("UPDATE orderline SET " + orderUpdate.getIid() +" WHERE oid = " + orderUpdate.getOid());
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//
//
//	public OrderUpdate updateQuantity(OrderUpdate orderUpdate) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("UPDATE orderline SET " + orderUpdate.getQuantity() +" WHERE oid = " + orderUpdate.getOid());
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//	public OrderUpdate readLatest() {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY oid DESC LIMIT 1");) {
//			resultSet.next();
//			return modelFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//	public OrderUpdate addToOrder() {
//		LOGGER.info("you shouldn't be seeing this");
//		return null;
//	}
//	@Override
//	public OrderUpdate updateRemoveFromOrder() {
//		LOGGER.info("you shouldn't be seeing this");
//		return null;
//	}
//	@Override
//	public OrderUpdate updateIid() {
//		LOGGER.info("you shouldn't be seeing this");
//		return null;
//	}
//	@Override
//	public OrderUpdate updateQuantity() {
//		LOGGER.info("you shouldn't be seeing this");
//		return null;
//	}
//
//
//
//
//
//
//}
