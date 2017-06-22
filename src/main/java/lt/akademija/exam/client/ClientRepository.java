package lt.akademija.exam.client;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ggrazevicius
 */
@Repository
public class ClientRepository {
	
	private static final Logger LOGGER = Logger.getLogger( ClientRepository.class.getName() );
	
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public Client get(Long id) {
    	LOGGER.log( Level.INFO, "OR LOGGING: client with id " + id + " info returned to program user" );
        return entityManager.find(Client.class, id);
    }

    @Transactional
    public Client save(Client client) {
    	LOGGER.log( Level.INFO, "OR LOGGING: new client saved" );
        return entityManager.merge(client);
    }

    @Transactional
    public void delete(Long id) {
    	LOGGER.log( Level.INFO, "OR LOGGING: client with id " + id + " removed" );
        entityManager.remove(entityManager.find(Client.class, id));
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
    	LOGGER.log( Level.INFO, "OR LOGGING: all clients from DB returned" );
    	return entityManager.createNamedQuery("findAllClients").getResultList();
    }
}
