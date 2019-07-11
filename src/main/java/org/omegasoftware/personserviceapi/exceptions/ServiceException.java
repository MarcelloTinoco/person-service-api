package org.omegasoftware.personserviceapi.exceptions;

public class ServiceException extends Exception{

	private static final long serialVersionUID = 1446294814874238377L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	
}
