package com.monsanto.exception;



public class BaseExceptions extends Exception {

	private static final long serialVersionUID = 7832737117963456839L;

	public BaseExceptions(String msg) {
		super(msg);
	}

	public BaseExceptions(Throwable e) {
		super(e);
	}

	public BaseExceptions(String msg, Throwable e) {
		super(msg,e);
	}

	public BaseExceptions() {
		super();
	}
	
}
