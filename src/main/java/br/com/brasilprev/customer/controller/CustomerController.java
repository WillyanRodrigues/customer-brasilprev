package br.com.brasilprev.customer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.customer.dto.CustomerDTO;
import br.com.brasilprev.customer.dto.GetCustomerRequestDTO;
import br.com.brasilprev.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Creates a new customer and returns it's properties with the id")
    @ApiResponses({
        @ApiResponse(code = 201, message = "If a new customer is sucessfully saved to the system."),
        @ApiResponse(code = 400, message = "If any of the required parameters is missing or malformed."),
        @ApiResponse(code = 500, message = "If has any unexpected error.")})
	public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customer) {
		return service.createCustomer(customer);
	}
	
	@GetMapping
	@ApiOperation(value = "Finds a customer either by it's id or document number")
    @ApiResponses({
        @ApiResponse(code = 200, message = "If a new customer is sucessfully returned."),
        @ApiResponse(code = 400, message = "If any of the required parameters is missing or malformed."),
        @ApiResponse(code = 404, message = "If the customer could not be found."),
        @ApiResponse(code = 500, message = "If has any unexpected error.")})
	public CustomerDTO getCustomer(@Valid GetCustomerRequestDTO request) {
		return service.getCustomer(request); 
	}
	
	@PutMapping
	@ApiOperation(value = "Updates customer information.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "If a new customer is sucessfully updated to the system."),
        @ApiResponse(code = 400, message = "If any of the required parameters is missing or malformed."),
        @ApiResponse(code = 500, message = "If has any unexpected error.")})
	public void updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		service.updateCustomer(customerDTO);
	}
	
	@DeleteMapping("/{customerId}")
	@ApiOperation(value = "Deletes a customer from the system")
    @ApiResponses({
        @ApiResponse(code = 200, message = "If a new customer is sucessfully deleted from the system."),
        @ApiResponse(code = 400, message = "If any of the required parameters is missing or malformed."),
        @ApiResponse(code = 500, message = "If has any unexpected error.")})
	public void deleteCustomer(@PathVariable(name = "customerId", required = true) Long customerId) {
		service.deleteCustomer(customerId);
	}
	
}
