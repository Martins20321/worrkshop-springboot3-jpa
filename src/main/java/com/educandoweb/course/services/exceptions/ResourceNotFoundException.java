package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) { //Vou passar o id do objeto não encontrado
		super("Resource not found. Id " + id);
	}
}