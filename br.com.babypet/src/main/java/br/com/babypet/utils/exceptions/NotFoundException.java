package br.com.babypet.utils.exceptions;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException() {
		super("NOT FOUND !!!!!!!!!!!");
	}
	
	public NotFoundException(String message) {
		super(message);
	}

}
