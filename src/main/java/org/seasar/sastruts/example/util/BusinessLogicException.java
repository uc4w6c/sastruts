package org.seasar.sastruts.example.util;

public class BusinessLogicException extends RuntimeException {
	public BusinessLogicException(String message) {
		super(message);
	}

	public BusinessLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessLogicException(Throwable cause) {
		super(cause);
	}

}
