package br.com.brasilprev.customer.constants;

public class MessagesConstants {

	public static final String CREATE_SAVE_ERROR = "Could not save customer to database. Please review your request and try again";
	public static final String EXISTING_CUSTOMER_ERROR = "The document provided is already in our database. Please try to find customer information by this document number";
	public static final String CUSTOMER_NOT_FOUND_ERROR = "Could not find any customer.";
	public static final String SEARCH_ERROR = "Could not find any customer due to unexpected reasons. Please try again later";
	public static final String UPDATE_SAVE_ERROR = "Could not update customer information to database. Please review your request and try again";
	public static final String DELETE_ERROR = "Could not delete the customer by it's id. Please try again later, or try checking if the id is correct";
	public static final String UNEXPECTED_ERROR = "An unexpected error occurred, please try again. If the error persists, please contact an administrator";
	public static final String HEADER_REQUIRED_ERROR = "Please inform security token and transaction-id inside header section";
}
