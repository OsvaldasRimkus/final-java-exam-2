package tests;

import org.junit.Assert;
import org.junit.Test;

import lt.akademija.exam.client.Client;
import lt.akademija.exam.client.ClientRepository;

public class Tests {
	
	
	
	@Test
	public void canSaveNewClientInDB(){
		ClientRepository clientRepository = new ClientRepository();
		Client clientA = new Client("Tom", "Smith", "2000-01-01", "123456789", "VIP");
		Client clientB = new Client("Tom", "John", "2000-01-01", "123456789", "Regular");
		clientRepository.save(clientA);
		clientRepository.save(clientB);
		Assert.assertEquals(2, clientRepository.findAll().size());
	}
	
	@Test
	public void cannotSaveNewClientWithSameNameSurnameAndBirthDate(){
		ClientRepository clientRepository = new ClientRepository();
		Client clientA = new Client("Tom", "Smith", "2000-01-01", "123456789", "VIP");
		Client clientB = new Client("Tom", "Smith", "2000-01-01", "123456789", "Regular");
		clientRepository.save(clientA);
		clientRepository.save(clientB);
		Assert.assertEquals(1, clientRepository.findAll().size());
	}
}
