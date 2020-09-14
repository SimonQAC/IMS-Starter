package com.qa.ims.controller;

import java.util.List;

/**
 * Update Controller. Takes in inputs for each action
 * to be sent to a service class
 */
public interface UpdateController<T> {

	List<T> removeFromOrder();

	T addToOrder();

	T updateCid();

	T updateIid();

}
