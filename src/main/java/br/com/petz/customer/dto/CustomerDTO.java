package br.com.petz.customer.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class CustomerDTO {

	private Long customerId;
	
	@NotNull
	@NotEmpty
	private String firstName;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)
	@NotNull
	private LocalDate dateOfBirth;
	
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	private DocumentDTO document;
	
	@NotNull
	private AddressDTO address;
	
	@NotNull
	private List<ContactNumberDTO> phones;
	
	@NotNull
	@NotEmpty
	private String email;
	
	public Boolean update() {
		return null != customerId;
	}
	
}
