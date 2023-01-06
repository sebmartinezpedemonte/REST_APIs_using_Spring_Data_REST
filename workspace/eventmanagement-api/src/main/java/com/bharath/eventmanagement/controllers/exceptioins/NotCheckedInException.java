package com.bharath.eventmanagement.controllers.exceptioins;


public class NotCheckedInException extends RuntimeException {

	private static final long serialVersionUID = 5812177045134178385L;

	public NotCheckedInException() {
		super();
	}

	public NotCheckedInException(String message) {
		super(message);
	}

	

}
