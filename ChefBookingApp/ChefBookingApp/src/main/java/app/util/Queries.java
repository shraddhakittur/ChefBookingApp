package app.util;

public class Queries {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/chefdb";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "admin@123";
	
	public static final String CREATE_CHEF_QUERY = "CREATE TABLE chef ( id INT NOT NULL AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, mobile_no CHAR(10) NOT NULL, cusine VARCHAR(50) NOT NULL, PRIMARY KEY (id) );";
	public static final String CREATE_BOOKING_QUERY = "CREATE TABLE booking ( id INT NOT NULL AUTO_INCREMENT, chef_id INT NOT NULL, cusine VARCHAR(50) NOT NULL, guests INT NOT NULL CHECK (guests > 0), place VARCHAR(100) NOT NULL, date DATE NOT NULL CHECK (date >= CURRENT_DATE()), PRIMARY KEY (id), FOREIGN KEY (chef_id) REFERENCES chef(id) );";

}
