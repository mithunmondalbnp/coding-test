package com.monsanto.exception;

public class InvalidIngredientCountException extends BaseExceptions{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidIngredientCountException(String msg) {
		super(msg);
	}

	public InvalidIngredientCountException(Throwable e) {
		super(e);
	}

	public InvalidIngredientCountException(String msg, Throwable e) {
		super(msg,e);
	}

	public InvalidIngredientCountException() {
		super();
	}
}
