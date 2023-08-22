package app.model;

import java.io.Serializable;

public class Chef implements Serializable {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = -632742899721165632L;
	
	private int id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String cusine;
    
    
    public Chef() {
            
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }




	@Override
	public String toString() {
		return "Chef [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", cusine=" + cusine + "]";
	}
    
    
}
