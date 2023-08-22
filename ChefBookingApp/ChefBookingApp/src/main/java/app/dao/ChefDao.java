package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Chef;
import app.util.Queries;

// The concrete class that implements the ChefDao interface and provides JDBC logic
public class ChefDao implements IChefDao {

    private static final String DB_URL = Queries.DB_URL;
    private static final String DB_USER = Queries.DB_USERNAME;
    private static final String DB_PASSWORD = Queries.DB_PASSWORD;

    private static final String GET_CHEF_BY_ID = "SELECT * FROM chef WHERE id = ?";
    private static final String GET_ALL_CHEFS = "SELECT * FROM chef";
    private static final String INSERT_CHEF = "INSERT INTO chef (first_name, last_name, mobile_no, cusine) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CHEF = "UPDATE chef SET first_name = ?, last_name = ?, mobile_no = ?, cusine = ? WHERE id = ?";
    private static final String DELETE_CHEF = "DELETE FROM chef WHERE id = ?";

    @Override
    public Chef get(int id) {
        Chef chef = null;

        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Prepare a statement to execute the SQL query
            try (PreparedStatement statement = connection.prepareStatement(GET_CHEF_BY_ID)) {

                // Set the id parameter
                statement.setInt(1, id);

                // Execute the query and get the result set
                try (ResultSet resultSet = statement.executeQuery()) {

                    // If there is a result, create a Chef object and set its attributes
                    if (resultSet.next()) {
                        chef = new Chef();
                        chef.setId(resultSet.getInt("id"));
                        chef.setFirstName(resultSet.getString("first_name"));
                        chef.setLastName(resultSet.getString("last_name"));
                        chef.setMobileNo(resultSet.getString("mobile_no"));
                        chef.setCusine(resultSet.getString("cusine"));
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }

        // Return the Chef object or null if not found
        return chef;
    }

    // Get all Chef objects from the database
    @Override
    public List<Chef> findChefs() {
        // Initialize a list of Chef objects to store the results
        List<Chef> chefs = new ArrayList<>();

        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Prepare a statement to execute the SQL query
            try (PreparedStatement statement = connection.prepareStatement(GET_ALL_CHEFS)) {

                // Execute the query and get the result set
                try (ResultSet resultSet = statement.executeQuery()) {

                    // Loop through each row of the result set and create a Chef object
                    while (resultSet.next()) {
                        Chef chef = new Chef();
                        chef.setId(resultSet.getInt("id"));
                        chef.setFirstName(resultSet.getString("first_name"));
                        chef.setLastName(resultSet.getString("last_name"));
                        chef.setMobileNo(resultSet.getString("mobile_no"));
                        chef.setCusine(resultSet.getString("cusine"));

                        // Add the Chef object to the list
                        chefs.add(chef);
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }

        // Return the list of Chef objects or an empty list if none found
        return chefs;
    }

    // Insert a new Chef object into the database
    @Override
    public void insert(Chef chef) {
        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Prepare a statement to execute the SQL update
            try (PreparedStatement statement = connection.prepareStatement(INSERT_CHEF)) {

                // Set the parameters for the Chef object
                statement.setString(1, chef.getFirstName());
                statement.setString(2, chef.getLastName());
                statement.setString(3, chef.getMobileNo());
                statement.setString(4, chef.getCusine());

                // Execute the update and get the number of affected rows
                int rows = statement.executeUpdate();

                // If the update was successful, print a message
                if (rows > 0) {
                    System.out.println("A new chef was inserted successfully!");
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
    }

    // Update an existing Chef object in the database
    @Override
    public void update(Chef chef) {
        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Prepare a statement to execute the SQL update
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_CHEF)) {

                // Set the parameters for the Chef object
                statement.setString(1, chef.getFirstName());
                statement.setString(2, chef.getLastName());
                statement.setString(3, chef.getMobileNo());
                statement.setString(4, chef.getCusine());
                statement.setInt(5, chef.getId());

                // Execute the update and get the number of affected rows
                int rows = statement.executeUpdate();

                // If the update was successful, print a message
                if (rows > 0) {
                    System.out.println("A chef was updated successfully!");
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
    }

    // Delete an existing Chef object from the database
    @Override
    public void delete(Chef chef) {
        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            try (PreparedStatement statement = connection.prepareStatement(DELETE_CHEF)) {

                statement.setInt(1, chef.getId());

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("A chef was deleted successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
}