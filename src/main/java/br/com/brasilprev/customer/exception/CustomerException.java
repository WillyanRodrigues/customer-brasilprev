package br.com.brasilprev.customer.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = -1363474622147616731L;
	
	private final String message;
	private final String detail;
	private final HttpStatus status;

	
	public CustomerException (String message, String detail, HttpStatus status) {
		super(message);
		this.message = message;
		this.detail = detail;
		this.status = status;
	}
	
	
	public CustomerException (String message, RuntimeException detail, HttpStatus status) {
		super(message);
		this.message = message;
		this.detail = detail.getMessage();
		this.status = status;
	}
	

	
	
	public boolean statusIsSet() {
		return null != status;
	}
	
}
