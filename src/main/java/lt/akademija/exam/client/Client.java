package lt.akademija.exam.client;

import javax.persistence.*;

/**
 * This is an entity class that hold client information.
 * 
 * @author ggrazevicius
 * @author orimkus
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllClients", query = "select client from Client client")
})
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;
    
    private String dateOfBirth;
    
    private String phoneNumber;
    
    private boolean isClientVIP;

    public Client( String firstName, String lastName, String dateOfBirth, String phoneNumber, boolean clientType) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.dateOfBirth = dateOfBirth;
    	this.phoneNumber = phoneNumber;
    	this.isClientVIP = clientType;
    }

    public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isClientVIP() {
		return isClientVIP;
	}

	public void setClientVIP(boolean isClientVIP) {
		this.isClientVIP = isClientVIP;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
