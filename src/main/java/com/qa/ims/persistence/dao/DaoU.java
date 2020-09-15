package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.OrderUpdate;

public interface DaoU<T> {

	List<T> readAll();

	T addToOrder(OrderUpdate orderUpdate);

	T updateRemoveFromOrder();
	
	T updateIid();
	
	T updateCid();

	T updateQuantity();
	
	T readLatest();

	T modelFromResultSet(ResultSet resultSet) throws SQLException;
}
