package app.client;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import app.model.Booking;
import app.model.Chef;
import app.service.BookingService;
import app.service.ChefService;
import app.service.IBookingService;
import app.service.IChefService;

public class Main {
	public static void main(String[] args) {
		IChefService chefService = new ChefService();
		IBookingService bookingService = new BookingService();
		
		Chef chef = new Chef();
		chef.setFirstName("Gordon");
		chef.setLastName("Ramsay");
		chef.setMobileNo("1234567890");
		chef.setCusine("European");
		
		chefService.add(chef);
		
		chef = chefService.get(1);
		
		System.out.println(chef);
		
		Booking booking = new Booking();
		booking.setChefId(chef.getId());
		booking.setCusine("European");
		booking.setGuests(100);
		booking.setPlace("Banglore");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2023, 12, 25);
		
		booking.setDate(Date.from(calendar.toInstant()));
		
		System.out.println(booking);
		
	}
}
