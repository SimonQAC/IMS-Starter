package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DaoU<T> {

	List<T> readAll();

	T addToOrder();

	T updateRemoveFromOrder();
	
	T updateIid();
	
	T updateCid();

	T updateQuantity();

	T modelFromResultSet(ResultSet resultSet) throws SQLException;
}
