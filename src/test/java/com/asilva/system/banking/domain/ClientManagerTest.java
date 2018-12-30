package com.asilva.system.banking.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.asilva.system.banking.exceptions.AgeNotAllowedExceptions;
import com.asilva.system.banking.repository.ClientManager;


/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe.
 * @author Alexander
 *
 */
public class ClientManagerTest {
	
	private long clientId_01 = 1;
	private long clientId_02 = 2;
	private long clientId_03 = 3;
	private ClientManager clientManager;

	@Before
	public void setUp() throws Exception {
		
		/* =========== Montando Cenário ========== */
		
		// Criando Clientes		
		 Client client01 = new Client(clientId_01, "Antônio Carlos", "antonio@test.com", 29, 1, true);
		 Client client02 = new Client(clientId_02, "Fernando Augusto", "fernando@test.com", 38, 1, false);		 
		
		// Criando lista de clientes
		List<Client> clients = new ArrayList<>();
		
		// Adicionando clientes na lista
		clients.add(client01);
		clients.add(client02);
		
		clientManager = new ClientManager(clients);
	}

	@After
	public void tearDown() throws Exception {
		
		clientManager.wipeUp();
	}

	/**
	 * Teste básico que busca cliente por Id.
	 */
	@Test
	public void testFindClientById() {
		
		/* ========== Execução ========== */
		Client clientRetriever = clientManager.findClientById(clientId_01);
		
		/* ========== Verificações ========== */
		assertEquals(clientId_01, clientRetriever.getClientId());
		//assertThat(clientRetriever.getClientId(), is(clientId_01));	
	}
	
	@Test
	public void testAddClient() {
		
		/* =========== Montando Cenário ========== */		
		Client client03 = new Client(clientId_03, "Luiz Gustavo", "luiz@test.com", 35, 1, true);
		
		/* ========== Execução ========== */
		clientManager.AddClient(client03);
		
		/* ========== Verificações ========== */		
		assertThat(clientManager.getClients().size(), is(3));
	}
	
	@Test
	public void testDeleteClientById() {
		
		/* ========== Execução ========== */
		boolean clientRemoved = clientManager.deleteClientById(clientId_02);
		
		/* ========== Verificações ========== */
		assertThat(clientRemoved, is(true));
		assertThat(clientManager.getClients().size(), is(1));
		assertNull(clientManager.findClientById(clientId_02));
	}
	
	@Test
	public void testActiveClient() {
		
		/* ========== Execução ========== */
		boolean activeClient = clientManager.activeClient(clientId_01);
		
		/* ========== Verificações ========== */
		assertThat(activeClient, is(true));
	}
	
	@Test 
	public void testExceptionOfAgeNotAllowedBelow18() throws AgeNotAllowedExceptions {
		
		/* =========== Montando Cenário ========== */		
		Client client03 = new Client(clientId_03, "Luiz Gustavo", "luiz@test.com", 17, 1, true);
	
		/* ========== Execução ========== */
		
		try {
			clientManager.validAge(client03.getAge());
			fail();
		}
		catch(Exception ex){
			/* ========== Verificações ========== */
			assertThat(ex.getMessage(), is(AgeNotAllowedExceptions.MSG_INVALID_AGE));
			
		}	
		
	}
	
	@Test 
	public void testExceptionOfAgeNotAllowedAbove65() throws AgeNotAllowedExceptions {
		
		/* =========== Montando Cenário ========== */		
		Client client03 = new Client(clientId_03, "Luiz Gustavo", "luiz@test.com", 66, 1, true);
	
		/* ========== Execução ========== */
		
		try {
			clientManager.validAge(client03.getAge());
			fail();
		}
		catch(Exception ex){
			/* ========== Verificações ========== */
			assertThat(ex.getMessage(), is(AgeNotAllowedExceptions.MSG_INVALID_AGE));
			
		}	
		
	}

}
