package br.com.petz.customer.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.petz.customer.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	public Optional<Customer> findByDocumentNumber(String documentNumber);
	
}
