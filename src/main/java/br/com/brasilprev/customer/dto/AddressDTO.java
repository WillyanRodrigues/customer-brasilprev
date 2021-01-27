package br.com.brasilprev.customer.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = Include.NON_NULL)
public class AddressDTO {

	@NotNull
	@NotEmpty
	private String streetName;
	
	private String number;
	
	@NotNull
	@NotEmpty
	private String zipCode;
	
	@NotNull
	@NotEmpty
	private String city;
	
	@NotNull
	@NotEmpty
	private String country;
	
	private String complement;
	
	
	public boolean hasComplement() {
		return null != complement;
	}
	
	public boolean hasNumber() {
		return null != number;
	}
}
