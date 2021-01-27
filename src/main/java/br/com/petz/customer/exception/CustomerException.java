package br.com.petz.customer.exception;

import lombok.Getter;

@Getter
public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = -1363474622147616731L;
	
	private final String message;
	private final String detail;

	
	public CustomerException (String message, String detail) {
		super(message);
		this.message = message;
		this.detail = detail;
	}
	
	public CustomerException (String message, RuntimeException detail) {
		super(message);
		this.message = message;
		this.detail = detail.getMessage();
	}
	
}
