package com.monsanto.exception;

public class NoRecordsFoundException extends BaseExceptions{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordsFoundException(String msg) {
		super(msg);
	}

	public NoRecordsFoundException(Throwable e) {
		super(e);
	}

	public NoRecordsFoundException(String msg, Throwable e) {
		super(msg,e);
	}

	public NoRecordsFoundException() {
		super();
	}
	
}
