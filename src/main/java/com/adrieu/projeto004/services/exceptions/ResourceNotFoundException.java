package com.adrieu.projeto004.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//exceção personalizada
	public ResourceNotFoundException(Object id) {
		super("Resource Not Found. ID " + id);
	}

}
