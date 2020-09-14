package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderUpdateController implements UpdateController<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	@Override
	public List<Order> removeFromOrder() {
		
		return null;
	}
	@Override
	public Order addToOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order updateCid() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order updateIid() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
