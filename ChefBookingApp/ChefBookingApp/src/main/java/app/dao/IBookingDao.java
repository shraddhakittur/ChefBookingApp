package app.dao;

import java.util.List;

import app.model.Booking;

//The abstract API for performing CRUD operations on Booking objects
public interface IBookingDao {

 // Get a Booking object by its id
 Booking findBooking(int id);

 // Get all Booking objects from the database
 List<Booking> findBookings();

 // Insert a new Booking object into the database
 void insert(Booking booking);

 // Update an existing Booking object in the database
 void update(Booking booking);

 // Delete an existing Booking object from the database
 void delete(Booking booking);
}