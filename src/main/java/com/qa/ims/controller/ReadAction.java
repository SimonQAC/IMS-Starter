package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * ReadAction is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum ReadAction {
	ALL("Read all orders"), ORDER("In depth print out of an individual order"), 
	RETURN("To return to domain selection");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	ReadAction(String description) {
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
	public static void printReadActions() {
		for (ReadAction updateAction : ReadAction.values()) {
			LOGGER.info(updateAction.getDescription());
		}
	}

	/**
	 * Gets an updateAction based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return ReadAction type
	 */
	public static ReadAction getReadAction(Utils utils) {
		ReadAction updateAction = null;
		do {
			try {
				updateAction = ReadAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (updateAction == null);
		return updateAction;
	}

}
