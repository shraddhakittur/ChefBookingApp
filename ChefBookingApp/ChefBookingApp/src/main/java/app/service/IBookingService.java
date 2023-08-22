package app.service;

import java.util.List;

import app.model.Booking;

public interface IBookingService {
	// Get a Booking object by its id
	 Booking get(int id) throws BookingNotFoundException;

	 // Get all Booking objects from the database
	 List<Booking> getAll() throws BookingNotFoundException;

	 // Insert a new Booking object into the database
	 void insert(Booking booking);

	 // Update an existing Booking object in the database
	 void update(Booking booking);

	 // Delete an existing Booking object from the database
	 void delete(Booking booking);

}
