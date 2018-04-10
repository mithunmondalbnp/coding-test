package com.monsanto.util;

import java.util.Collection;

/**
 *
 * @author archit.sud
 * This class will provide utility methods to check if String, List are empty or not.
 */
public class Format {

	/**
	 * Method to check if String is not empty and not null.
	 * @param arg
	 * @return Boolean
	 */
	public static Boolean isStringNotEmptyAndNotNull(String arg) {
		if (arg != null && !("").equals(arg) && !("").equals(arg.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if a List/Set is not null and not empty.
	 * @param c
	 * @return Boolean
	 */
	public static Boolean isCollectionNotEmtyAndNotNull(Collection<?> arg) {
		if (arg != null && !arg.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if an object is not null or zero.
	 * @param arg as Object
	 * @return true if object is not null or zero
	 */
	public static Boolean isObjectNotEmptyAndNotZero(Object arg) {
		if (arg != null) {
			return true;
		} else {
			return false;
		}
	}
}
