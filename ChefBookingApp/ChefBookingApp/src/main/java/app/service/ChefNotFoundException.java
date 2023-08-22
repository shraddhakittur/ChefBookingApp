package app.service;

public class ChefNotFoundException extends RuntimeException {

	public ChefNotFoundException() {
		super();
	}

	public ChefNotFoundException(String message) {
		super(message);
	}
	
}
