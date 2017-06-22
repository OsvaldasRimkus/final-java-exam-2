package lt.akademija.exam.client;

import javax.persistence.*;

/**
 * This is an entity class that hold client information.
 * 
 * @author ggrazevicius
 * @author orimkus
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllClients", query = "select client from Client client") })
public class Client {

	/**
	* Id of client
	*/
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * The name of a given client
	 */
	private String firstName;

	/**
	 * The surname of a given client
	 */
	private String lastName;

	/**
	 * the date of birth of a given client
	 */
	private String dateOfBirth;

	/**
	 * the phone number of a given client
	 */
	private String phoneNumber;

	/**
	 * the type of a client: Regular or VIP
	 */
	private String clientType;

	/**
	 * dummy constructor
	 */
	public Client() {

	}

	/**
	 * real constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param phoneNumber
	 * @param clientType
	 */
	public Client(String firstName, String lastName, String dateOfBirth, String phoneNumber, String clientType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.clientType = clientType;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
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

	public String getIsClientVIP() {
		return clientType;
	}

	public void setIsClientVIP(String isClientVIP) {
		this.clientType = isClientVIP;
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
