package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * UpdateAction is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum UpdateAction {
	ADD("Add an item to an existing order"), DEL("Remove an item from an existing order"), 
	IID("UpdateAction Item ID"), QTY("UpdateAction Quantity"), 
	RETURN("To return to domain selection");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	UpdateAction(String description) {
		this.description = description;
	}

	/**
	 * Describes the updateAction
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printUpdateActions() {
		for (UpdateAction updateAction : UpdateAction.values()) {
			LOGGER.info(updateAction.getDescription());
		}
	}

	/**
	 * Gets an updateAction based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return UpdateAction type
	 */
	public static UpdateAction getUpdateAction(Utils utils) {
		UpdateAction updateAction = null;
		do {
			try {
				updateAction = UpdateAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (updateAction == null);
		return updateAction;
	}

}
