package lt.akademija.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author orimkus
 *
 */
@RestController
@RequestMapping(value = "/")
public class ResourceController {

	@Autowired
	private ResourceRepository resourceRepository;

	/**
	 * 
	 * @return list of all resources in the database
	 */
	@GetMapping("/api/resources")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns all resources that are currently in the DB list")
	public List<Resource> getResources() {
		return resourceRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 *            id of Client to delete
	 */
	@DeleteMapping("/api/resources/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteResources(@PathVariable Long id) {
		resourceRepository.delete(id);
	}

	/**
	 * 
	 * @param client
	 *            object that holds data for new client creation
	 * @return
	 */
	@PostMapping("/api/resources")
	@ResponseStatus(HttpStatus.CREATED)
	public Resource registerResource(@RequestBody Resource client) {
		return resourceRepository.save(client);
	}
	
}
