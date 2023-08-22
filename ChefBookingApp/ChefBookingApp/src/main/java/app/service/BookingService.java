package app.service;

import java.util.List;

import app.dao.BookingDao;
import app.dao.IBookingDao;
import app.model.Booking;

public class BookingService implements IBookingService {

	private IBookingDao bookingDao = new BookingDao();
	
	@Override
	public Booking get(int id) {
		Booking booking =  bookingDao.findBooking(id);
		if (booking==null) {
			throw new BookingNotFoundException("Booking with given ID not found !");
		}
		return booking;
	}

	@Override
	public List<Booking> getAll() {
		List<Booking> bookings =  bookingDao.findBookings();
		if (bookings.isEmpty()) {
			throw new BookingNotFoundException("No bookings were found !");
		}
		return bookings;
	}

	@Override
	public void insert(Booking booking) {
		bookingDao.insert(booking);
	}

	@Override
	public void update(Booking booking) {
		bookingDao.update(booking);
	}

	@Override
	public void delete(Booking booking) {
		bookingDao.delete(booking);
	}

}
