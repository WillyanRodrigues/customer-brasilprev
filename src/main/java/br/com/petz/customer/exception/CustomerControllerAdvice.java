package br.com.petz.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.petz.customer.dto.APIErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class CustomerControllerAdvice {

	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	protected ResponseEntity<APIErrorResponseDTO> handle (MethodArgumentNotValidException ex){
		log.error(ex.getMessage());
		APIErrorResponseDTO responseError = new APIErrorResponseDTO(HttpStatus.BAD_REQUEST.name(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(responseError);
	}
	
	@ExceptionHandler(value = {org.springframework.validation.BindException.class})
	protected ResponseEntity<APIErrorResponseDTO> handle (org.springframework.validation.BindException ex){
		log.error(ex.getMessage());
		APIErrorResponseDTO responseError = new APIErrorResponseDTO(HttpStatus.BAD_REQUEST.name(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(responseError);
	}
	
	@ExceptionHandler(value = {CustomerException.class})
	protected ResponseEntity<APIErrorResponseDTO> handle (CustomerException ex){
		log.error(ex.getMessage());
		APIErrorResponseDTO responseError = new APIErrorResponseDTO(ex.getMessage(), ex.getDetail());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(responseError);
	}
	
	@ExceptionHandler(value = {CustomerNotFoundException.class})
	protected ResponseEntity<APIErrorResponseDTO> handle (CustomerNotFoundException ex){
		log.error(ex.getMessage());
		APIErrorResponseDTO responseError = new APIErrorResponseDTO(HttpStatus.NOT_FOUND.name(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(responseError);
	}
	
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<APIErrorResponseDTO> handle (Exception ex){
		log.error(ex.getMessage());
		APIErrorResponseDTO responseError = new APIErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(responseError);
	}
	
}
