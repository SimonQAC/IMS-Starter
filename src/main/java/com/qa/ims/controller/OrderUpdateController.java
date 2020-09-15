package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.DaoU;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderUpdateDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderUpdate;
import com.qa.ims.utils.Utils;

public class OrderUpdateController implements DaoU<OrderUpdate>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@SuppressWarnings("unused")
	private OrderUpdateDAO orderUpdateDAO;
	@SuppressWarnings("unused")
	private Utils utils;

	

}
