package app.service;

public class BookingNotFoundException extends RuntimeException {

	public BookingNotFoundException() {
		super();
	}

	public BookingNotFoundException(String message) {
		super(message);
	}

}
