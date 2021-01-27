package br.com.petz.customer.dto;

import br.com.petz.customer.annotation.CombinedNotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CombinedNotNull(fields = {
	      "customerId",
	      "documentNumber"
	})
public class GetCustomerRequestDTO {

	public Long customerId;
	public String documentNumber;
	
	
	public boolean hasCustomerId() {
		return null != customerId;
	}
	
	public boolean hasDocumentNumber() {
		return null != documentNumber;
	}
	
}
