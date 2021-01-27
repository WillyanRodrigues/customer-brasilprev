package br.com.petz.customer.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class APIErrorResponseDTO {

	private final String message;
	private final String detail;
	private final LocalDateTime timestamp;
	
	public APIErrorResponseDTO(String message, String detail) {
		this.message = message;
		this.detail = detail;
		this.timestamp = LocalDateTime.now();
	}
	
}
