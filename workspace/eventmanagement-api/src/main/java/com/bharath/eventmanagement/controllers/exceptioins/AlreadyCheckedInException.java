package com.bharath.eventmanagement.controllers.exceptioins;


public class AlreadyCheckedInException extends RuntimeException {

	private static final long serialVersionUID = 7451808432693787850L;

	public AlreadyCheckedInException() {
		super();		
	}

	public AlreadyCheckedInException(String message) {
		super(message);
	}

	

}
