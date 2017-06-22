package lt.akademija.exam.client;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author ggrazevicius
 * @author orimkus
 */
@Repository
public class ClientRepository {

	private static final Logger LOGGER = Logger.getLogger(ClientRepository.class.getName());

	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * returns a client entity from DB by ID
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Client get(Long id) {
		LOGGER.log(Level.INFO, "OR LOGGING: client with id " + id + " info returned to program user");
		return entityManager.find(Client.class, id);
	}

	/**
	 * saves client to the DB
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client save(Client client) {
		// gets all clients
		List<Client> clients = entityManager.createNamedQuery("findAllClients").getResultList();
		// loops through all clients to search for duplicate
		for (Client c : clients) {
			System.out.println(c.getFirstName() + " " + client.getFirstName());
			System.out.println(c.getLastName() + " " + client.getLastName());
			System.out.println(c.getDateOfBirth() + " " + client.getDateOfBirth());

			if (c.getFirstName().equals(client.getFirstName()) && c.getLastName().equals(client.getLastName())
					&& c.getDateOfBirth().equals(client.getDateOfBirth())) {
				LOGGER.log(Level.WARNING,
						"OR LOGGING: cannot save client, because client with the same name surname and date of birth already exists in the DB");
				return null;
			}
		}
		// checks if client has empty fields
		if (client.getFirstName().equals("") || client.getLastName().equals("") || client.getDateOfBirth().equals("")
				|| client.getPhoneNumber().equals("") || client.getClientType().equals("")) {

			LOGGER.log(Level.WARNING, "OR LOGGING: cannot save client, all fields are mandatory");
			return null;
		}

		LOGGER.log(Level.INFO, "OR LOGGING: new client saved");
		return entityManager.merge(client);
	}

	/**
	 * deletes client from DB by ID
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		LOGGER.log(Level.INFO, "OR LOGGING: client with id " + id + " removed");
		entityManager.remove(entityManager.find(Client.class, id));
	}

	/**
	 * finds all Clients that are in DB
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		LOGGER.log(Level.INFO, "OR LOGGING: all clients from DB returned");
		return entityManager.createNamedQuery("findAllClients").getResultList();
	}
}
