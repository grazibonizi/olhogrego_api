package br.com.fiap.exception;

public class EntityNotFoundException extends Exception{

	public EntityNotFoundException() {
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
}
