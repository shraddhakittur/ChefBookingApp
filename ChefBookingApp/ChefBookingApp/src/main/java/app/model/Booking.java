package app.model;

import java.io.Serializable;
import java.util.Date;

// A bean class that encapsulates the attributes of a booking entity
public class Booking implements Serializable {

    // Private fields for attributes
    private int id;
    private int chefId;
    private String cusine;
    private int guests;
    private String place;
    private Date date;

    // Public no-argument constructor
    public Booking() {
        // Initialize fields with default values
    }

    // Public getter and setter methods for each attribute

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	@Override
	public String toString() {
		return "Booking [id=" + id + ", chefId=" + chefId + ", cusine=" + cusine + ", guests=" + guests + ", place="
				+ place + ", date=" + date + "]";
	}
    
    
}