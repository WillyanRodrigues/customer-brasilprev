package br.com.petz.customer.exception;

import br.com.petz.customer.dto.GetCustomerRequestDTO;
import lombok.Getter;

@Getter
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3971190875349705152L;
	
	private final String message;
	
	public CustomerNotFoundException(String message , GetCustomerRequestDTO request) {
		this.message = request.hasCustomerId() ? message.concat(" The provided id was " + request.getCustomerId()) : message.concat(" The provided document number was " + request.getDocumentNumber());
	}
	
	
	
}
