package br.com.brasilprev.customer.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import br.com.brasilprev.customer.dto.AddressDTO;
import br.com.brasilprev.customer.dto.ContactNumberDTO;
import br.com.brasilprev.customer.dto.CustomerDTO;
import br.com.brasilprev.customer.dto.DocumentDTO;
import br.com.brasilprev.customer.dto.DocumentType;
import br.com.brasilprev.customer.entity.Address;
import br.com.brasilprev.customer.entity.ContactNumber;
import br.com.brasilprev.customer.entity.Customer;

@Component
public class CustomerHelper {

	/* ------------ METHODS TO CONVERT FROM DTO CLASSES TO ENTITY CLASSES ------------ */
	
	public Customer fromDTOToEntity(CustomerDTO dto) {
		
		 Customer entity = Customer.builder()
				.documentNumber(dto.getDocument().getNumber())
				.documentType(dto.getDocument().getType().name())
				.email(dto.getEmail())
				.dateOfBirth(dto.getDateOfBirth())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.address(fromAddressDTOToAddressEntity(dto.getAddress()))
				.phones(fromPhonesDTOToPhonesEntity(dto.getPhones()))
				.build();
		 
		 if(dto.update()) {
			 entity.setId(dto.getCustomerId());
		 }
		return entity;
	}

	private List<ContactNumber> fromPhonesDTOToPhonesEntity(List<ContactNumberDTO> dtos) {
		List<ContactNumber> entities = Lists.newArrayList();
		dtos.forEach(dto -> {
			entities.add(ContactNumber.builder()
				.areaCode(dto.getAreaCode())
				.countryCode(dto.getCountryCode())
				.phoneNumber(dto.getPhoneNumber())
				.main(dto.getMain())
				.build());
		});
		return entities;
	}

	private Address fromAddressDTOToAddressEntity(AddressDTO dto) {
		
		return	Address.builder()
				.city(dto.getCity())
				.complement(dto.hasComplement() ? dto.getComplement() : "")
				.country(dto.getCountry())
				.number(dto.hasNumber() ? dto.getNumber() : "")
				.streetName(dto.getStreetName())
				.zipCode(dto.getZipCode())
				.build();
	}
	
	
	/* ------------ METHODS TO CONVERT FROM ENTITY CLASSES TO DTO CLASSES ------------ */
	
	public CustomerDTO fromEntityToDTO(Customer entity) {
		return CustomerDTO.builder()
				.customerId(entity.getCustomerId())
				.email(entity.getEmail())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.dateOfBirth(entity.getDateOfBirth())
				.document(fromDocumentEntityToDocumentDTO(entity.getDocumentNumber(), entity.getDocumentType()))
				.address(fromAddressEntityToAddressDTO(entity.getAddress()))
				.phones(fromPhonesEntityToPhonesDTO(entity.getPhones()))
				.build();
	}
	
	private List<ContactNumberDTO> fromPhonesEntityToPhonesDTO(List<ContactNumber> phones) {
		List<ContactNumberDTO> dtos = Lists.newArrayList();
		phones.forEach(entity -> {
			dtos.add(ContactNumberDTO.builder()
					.countryCode(entity.getCountryCode())
					.areaCode(entity.getAreaCode())
					.phoneNumber(entity.getPhoneNumber())
					.main(entity.getMain())
					.build());
			
		});
		return dtos;
	}

	private AddressDTO fromAddressEntityToAddressDTO(Address entity) {
		return AddressDTO.builder()
				.city(entity.getCity())
				.complement(entity.getComplement())
				.number(entity.getNumber())
				.streetName(entity.getStreetName())
				.country(entity.getCountry())
				.zipCode(entity.getZipCode())
				.build();
	}

	private DocumentDTO fromDocumentEntityToDocumentDTO (String documentNumber, String documentType) {
		return DocumentDTO.builder()
				.number(documentNumber)
				.type(DocumentType.valueOf(documentType))
				.build();
		
	}
	
}
