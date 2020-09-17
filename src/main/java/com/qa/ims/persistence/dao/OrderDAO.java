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


	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders (oid, cid) values (" + order.getOid() + ", " + order.getCid() + " );");
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
		LOGGER.info("You shouldn't be updating here");
		return null;
	}

	public Order addToOrder(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
					statement.executeUpdate("insert into orderline (oid, iid, quantity) values (" + order.getOid() + ", " + order.getIid() + ", " + order.getQuantity() + ")");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order updateRemoveFromOrder(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
					statement.executeUpdate("DELETE FROM orderline WHERE oid = " + order.getOid() + " AND iid=" + order.getIid());
					return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// old non working readorderline
//	public List<Order> readOrderLine() {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("select orderline.oid,orders.cid,orderline.iid,orderline.quantity,items.name,items.price, quantity*price as total from orders, orderline, items where orders.oid = orderline.oid and items.iid = orderline.iid order by orders.oid;");) {
//			List<Order> orders = new ArrayList<>();
//			while (resultSet.next()) {
//				orders.add(modelFromResultSet(resultSet));
//			}
//			return orders;
//		} catch (SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return new ArrayList<>();
//	}
	
	public Order readOrderLine(){
		String query = "select orderline.oid,orders.cid,orderline.iid,orderline.quantity,items.name,items.price, quantity*price as total from orders, orderline, items where orders.oid = orderline.oid and items.iid = orderline.iid order by orders.oid;";
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);){
			int x = 0;
			Long checkOid = null;
			while (resultSet.next()) {
				if (x == 0) {checkOid = resultSet.getLong(1);x=1;};
		    	  if (checkOid == resultSet.getLong(1)) {
		    		  String query2 ="select sum(quantity*price) as total from orders, orderline, items where orders.oid=orderline.oid and items.iid = orderline.iid and orders.oid =" + resultSet.getString(1);
		    			try (Connection connection2 = DBUtils.getInstance().getConnection();
		    					Statement statement2 = connection2.createStatement();
		    					ResultSet resultSet2 = statement2.executeQuery(query2);){
		    				while (resultSet2.next()) {
		    					LOGGER.info("------- Order " + resultSet.getString(1) + " - Total Price " + resultSet2.getDouble(1) +  " ---------");
		    					}
		    			} catch (SQLException e) {
		    				e.printStackTrace();
		    			}

		    	  };
		        LOGGER.info("Order ID=" + resultSet.getString(1) + " Customer ID=" + resultSet.getString(2));
		        LOGGER.info("Item ID=" + resultSet.getString(3) + " Price=" + resultSet.getString(6));
		        LOGGER.info("Total =" + resultSet.getString(7));
		        LOGGER.info("");
		        if(checkOid == resultSet.getLong(1)) {
		        checkOid = checkOid + 1;
		        }
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return null;
				
	}
	
	public Order readIndividualOrder(Order order) {
		String query = "select orderline.oid,orders.cid,orderline.iid,orderline.quantity,items.name,items.price, quantity*price as total from orders, orderline, items where orders.oid = orderline.oid and items.iid = orderline.iid and orderline.oid = "+ order.getOid() +" order by orders.oid;";
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);){
			int x = 0;
			while (resultSet.next()) {
				if( x == 0) {LOGGER.info("---- Order Info -----");LOGGER.info("Order ID=" + resultSet.getString(1) + " Customer ID=" + resultSet.getString(2));LOGGER.info("---------------------"); x =1;};
		        LOGGER.info("Item ID=" + resultSet.getString(3) + " Quantity=" + resultSet.getString(4));
		        LOGGER.info("Name =" + resultSet.getString(5) + " Price =" + resultSet.getString(6));
		        LOGGER.info("Total =" + resultSet.getString(7));
		        LOGGER.info("--------------------");
		      }}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		  String query2 ="select sum(quantity*price) as total from orders, orderline, items where orders.oid=orderline.oid and items.iid = orderline.iid and orders.oid =" + order.getOid();
			try (Connection connection2 = DBUtils.getInstance().getConnection();
					Statement statement2 = connection2.createStatement();
					ResultSet resultSet2 = statement2.executeQuery(query2);){
				while (resultSet2.next()) {
					LOGGER.info("Total Price " + resultSet2.getDouble(1));
					LOGGER.info("--------------------");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public Order readTotalPrice() {
		LOGGER.info("test");
		return null;
	}
}

