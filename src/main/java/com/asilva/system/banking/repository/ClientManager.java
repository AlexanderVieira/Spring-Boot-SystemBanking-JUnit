/**
 * 
 */
package com.asilva.system.banking.repository;

import java.util.List;

import com.asilva.system.banking.domain.Client;
import com.asilva.system.banking.exceptions.AgeNotAllowedExceptions;

/**
 * Classe que realiza operações com os clientes do banco.
 * @author Alexander
 *
 */
public class ClientManager {

	private List<Client> clients;
	
	/**
	 * @param clients
	 */
	public ClientManager(List<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	/**
	 * Limpa a lista de clientes, ou seja, remove todos eles. 
	 */
	public void wipeUp() {
		clients.clear();
	}
	
	/**
	 * Pesquisa por um cliente a partir do seu ID.
	 * @param clienteId do cliente a ser pesquisado
	 * @return o cliente pesquisado ou null, caso não seja encontrado
	 */
	public Client findClientById(long clientId) {
		
		for (Client client : clients) {
			if(client.getClientId() == clientId)
				return client;
		}
		return null;
	}
	
	/**
	 * Adiciona um novo cliente à lista de clientes do banco.
	 * @param novoCliente novo cliente a ser adicionado
	 */
	public void AddClient(Client client) {
		clients.add(client);
	}
	
	/**
	 * Remove cliente da lista de clientes do banco.
	 * @param clienteId do cliente a ser removido 
	 * @return true se o cliente foi removido. False, caso contrário.
	 */
	public boolean deleteClientById(long clientId) {
		boolean clientRemoved = false;
		
		for(int i = 0; i < clients.size(); i++) {
			Client client = clients.get(i);
			if(client.getClientId() == clientId) {
				clients.remove(i);
				clientRemoved = true;
				break;
			}
		}		
		return clientRemoved;
	}
	
	/**
	 * Informa se um determinado cliente está ativo ou não.
	 * @param clienteId do cliente cujo status será verificado
	 * @return true se o cliente está ativo. False, caso contrário. 
	 */
	public boolean activeClient(long clientId) {
		boolean activeClient = false;
		
		for(int i = 0; i < clients.size(); i++) {
			Client client = clients.get(i);
			if(client.getClientId() == clientId) {
				if(client.isActived()) {
					activeClient = true;
					break;
				}
			}			
		}
		return activeClient;
	}
	
	/**
	 * Valida se a idade do cliente está dentro do intervalo permitido (18 - 65).
	 * @param idade a idade do possível novo cliente
	 */
	public boolean validAge(int age) throws AgeNotAllowedExceptions {
		if(age < 18 || age > 65) {
			throw new AgeNotAllowedExceptions(AgeNotAllowedExceptions.MSG_INVALID_AGE);
		}
		return true;
	}
}
