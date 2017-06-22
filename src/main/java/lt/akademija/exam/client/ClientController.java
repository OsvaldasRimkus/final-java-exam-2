package lt.akademija.exam.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller controls data requests from the application to the server side
 * 
 * @author orimkus
 *
 */
@RestController
@RequestMapping(value = "/")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    /**
     * 
     * @return list of all clients in the database
     */
    @GetMapping("/api/clients")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns all clients that are currently in the DB list")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
    /**
     * 
     * @param id id of Client to delete
     */
    @DeleteMapping("/api/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable Long id) {
        clientRepository.delete(id);
    }
    /**
     * 
     * @param client object that holds data for new client creation
     * @return
     */
    @PostMapping("/api/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client registerClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
