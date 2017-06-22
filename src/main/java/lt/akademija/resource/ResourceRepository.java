package lt.akademija.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lt.akademija.exam.client.ClientRepository;

public class ResourceRepository {

	private static final Logger LOGGER = Logger.getLogger(ClientRepository.class.getName());
	
	private boolean[] sectors = new boolean[50];
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void delete(Long id) {
		LOGGER.log(Level.INFO, "OR LOGGING: resource with id " + id + " removed");
		entityManager.remove(entityManager.find(Resource.class, id));
	}

	public Resource save(Resource resource) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		resource.setDateOfKeepingStart(dateFormat.format(date).toString());
		for (int i = 0; i < sectors.length; i++) {
			if (sectors[i] == false) {
				resource.setResourceKeepingSector("" + i);
				break;
			}
		}
		if (resource.getResourceKeepingSector().equals("N/A")) {
			LOGGER.log(Level.INFO, "OR LOGGING: new resource coule not be saved, all holding sectors are ocupied");
			return null;
		}
		
		LOGGER.log(Level.INFO, "OR LOGGING: new resource saved");
		return entityManager.merge(resource);
	}

	public List<Resource> findAll() {
		LOGGER.log(Level.INFO, "OR LOGGING: all resources from DB returned");
		return entityManager.createNamedQuery("findAllResources").getResultList();
	}
	
}
