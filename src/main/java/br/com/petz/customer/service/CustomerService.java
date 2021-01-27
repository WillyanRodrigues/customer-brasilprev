package br.com.petz.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.customer.constants.MessagesConstants;
import br.com.petz.customer.dto.CustomerDTO;
import br.com.petz.customer.dto.GetCustomerRequestDTO;
import br.com.petz.customer.entity.Customer;
import br.com.petz.customer.exception.CustomerException;
import br.com.petz.customer.helper.CustomerHelper;
import br.com.petz.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private CustomerHelper helper;

	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		try {
			Customer customer = repository.save(helper.fromDTOToEntity(customerDTO));
			customerDTO.setCustomerId(customer.getCustomerId());
			return customerDTO;
		} catch (org.springframework.dao.DataIntegrityViolationException ex) {
			log.error(MessagesConstants.EXISTING_CUSTOMER_ERROR, ex);
			throw new CustomerException(MessagesConstants.EXISTING_CUSTOMER_ERROR, ex);
		} catch (RuntimeException ex) {
			log.error(MessagesConstants.CREATE_SAVE_ERROR, ex);
			throw new CustomerException(MessagesConstants.CREATE_SAVE_ERROR, ex);
		}
	}

	public CustomerDTO getCustomer(GetCustomerRequestDTO request) {
		try {
			Optional<Customer> customer = request.hasCustomerId() ? repository.findById(request.getCustomerId()) : repository.findByDocumentNumber(request.getDocumentNumber());
			if (customer.isPresent()) {
				return helper.fromEntityToDTO(customer.get());
			} else {
				log.error(MessagesConstants.CUSTOMER_NOT_FOUND_ERROR);
				throw new CustomerException(MessagesConstants.CUSTOMER_NOT_FOUND_ERROR, "");
			}
		} catch (CustomerException ex) {
			throw ex;

		} catch (RuntimeException ex) {
			log.error(MessagesConstants.SEARCH_ERROR, ex);
			throw new CustomerException(MessagesConstants.SEARCH_ERROR, ex);
		}
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		try {
			Customer entityToSave = helper.fromDTOToEntity(customerDTO);
			Optional<Customer> savedEntity = repository.findById(customerDTO.getCustomerId());
			if(savedEntity.isPresent()) {
				savedEntity.get().update(entityToSave);
				repository.save(savedEntity.get());
			}
		} catch (RuntimeException ex) {
			log.error(MessagesConstants.UPDATE_SAVE_ERROR, ex);
			throw new CustomerException(MessagesConstants.UPDATE_SAVE_ERROR, ex);
		}
	}

	public void deleteCustomer(Long customerId) {
		try {
			repository.deleteById(customerId);
		} catch (RuntimeException ex) {
			log.error(MessagesConstants.DELETE_ERROR, ex);
			throw new CustomerException(MessagesConstants.DELETE_ERROR, ex);
		}
	}

}
