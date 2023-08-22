package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Booking;
import app.util.Queries;

// The concrete class that implements the BookingDao interface and provides JDBC logic
public class BookingDao implements IBookingDao {

    // The database URL, username and password

    // The SQL statements for each operation
    private static final String GET_BOOKING_BY_ID = "SELECT * FROM booking WHERE id = ?";
    private static final String GET_ALL_BOOKINGS = "SELECT * FROM booking";
    private static final String INSERT_BOOKING = "INSERT INTO booking (chef_id, cusine, guests, place, date) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_BOOKING = "UPDATE booking SET chef_id = ?, cusine = ?, guests = ?, place = ?, date = ? WHERE id = ?";
    private static final String DELETE_BOOKING = "DELETE FROM booking WHERE id = ?";

    // Get a Booking object by its id
    @Override
    public Booking findBooking(int id) {
        // Initialize a Booking object to store the result
        Booking booking = null;

        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(Queries.DB_URL, Queries.DB_USERNAME, Queries.DB_PASSWORD)) {

            // Prepare a statement to execute the SQL query
            try (PreparedStatement statement = connection.prepareStatement(GET_BOOKING_BY_ID)) {

                // Set the id parameter
                statement.setInt(1, id);

                // Execute the query and get the result set
                try (ResultSet resultSet = statement.executeQuery()) {

                    // If there is a result, create a Booking object and set its attributes
                    if (resultSet.next()) {
                        booking = new Booking();
                        booking.setId(resultSet.getInt("id"));
                        booking.setChefId(resultSet.getInt("chef_id"));
                        booking.setCusine(resultSet.getString("cusine"));
                        booking.setGuests(resultSet.getInt("guests"));
                        booking.setPlace(resultSet.getString("place"));
                        booking.setDate(resultSet.getDate("date"));
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }

        // Return the Booking object or null if not found
        return booking;
    }

    // Get all Booking objects from the database
    @Override
    public List<Booking> findBookings() {
        // Initialize a list of Booking objects to store the results
        List<Booking> bookings = new ArrayList<>();

        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(Queries.DB_URL, Queries.DB_USERNAME, Queries.DB_PASSWORD)) {

            // Prepare a statement to execute the SQL query
            try (PreparedStatement statement = connection.prepareStatement(GET_ALL_BOOKINGS)) {

                // Execute the query and get the result set
                try (ResultSet resultSet = statement.executeQuery()) {

                    // Loop through each row of the result set and create a Booking object
                    while (resultSet.next()) {
                        Booking booking = new Booking();
                        booking.setId(resultSet.getInt("id"));
                        booking.setChefId(resultSet.getInt("chef_id"));
                        booking.setCusine(resultSet.getString("cusine"));
                        booking.setGuests(resultSet.getInt("guests"));
                        booking.setPlace(resultSet.getString("place"));
                        booking.setDate(resultSet.getDate("date"));

                        // Add the Booking object to the list
                        bookings.add(booking);
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }

        // Return the list of Booking objects or an empty list if none found
        return bookings;
    }

    // Insert a new Booking object into the database
    @Override
    public void insert(Booking booking) {
        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(Queries.DB_URL, Queries.DB_USERNAME, Queries.DB_PASSWORD)) {

            // Prepare a statement to execute the SQL update
            try (PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING)) {

                // Set the parameters for the Booking object
                statement.setInt(1, booking.getChefId());
                statement.setString(2, booking.getCusine());
                statement.setInt(3, booking.getGuests());
                statement.setString(4, booking.getPlace());
                statement.setDate(5, new java.sql.Date(booking.getDate().getTime()));

                // Execute the update and get the number of affected rows
                int rows = statement.executeUpdate();

                // If the update was successful, print a message
                if (rows > 0) {
                    System.out.println("A new booking was inserted successfully!");
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
    }

    // Update an existing Booking object in the database
    @Override
    public void update(Booking booking) {
        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(Queries.DB_URL, Queries.DB_USERNAME, Queries.DB_PASSWORD)) {

            // Prepare a statement to execute the SQL update
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING)) {

                // Set the parameters for the Booking object
                statement.setInt(1, booking.getChefId());
                statement.setString(2, booking.getCusine());
                statement.setInt(3, booking.getGuests());
                statement.setString(4, booking.getPlace());
                statement.setDate(5, new java.sql.Date(booking.getDate().getTime()));
                statement.setInt(6, booking.getId());

                // Execute the update and get the number of affected rows
                int rows = statement.executeUpdate();

                // If the update was successful, print a message
                if (rows > 0) {
                    System.out.println("A booking was updated successfully!");
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
    }

    // Delete an existing Booking object from the database
    @Override
    public void delete(Booking booking) {
        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(Queries.DB_URL, Queries.DB_USERNAME, Queries.DB_PASSWORD)) {

            // Prepare a statement to execute the SQL update
            try (PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING)) {

                // Set the id parameter for the Booking object
                statement.setInt(1, booking.getId());

                // Execute the update and get the number of affected rows
                int rows = statement.executeUpdate();

                // If the update was successful, print a message
                if (rows > 0) {
                    System.out.println("A booking was deleted successfully!");
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
    }
}