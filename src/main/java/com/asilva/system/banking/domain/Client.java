package com.asilva.system.banking.domain;


/**
 * Classe que representa um cliente real do banco.
 * @author Alexander
 *
 */
public class Client {
	
	private long clientId;
	private String name;
	private String email;
	private int age;
	private long accountManagerId;
	private boolean actived;
		
	/**
	 * @param clientId
	 * @param name
	 * @param email
	 * @param age
	 * @param accountManagerId
	 * @param actived
	 */
	public Client(long clientId, String name, String email, int age, long accountManagerId, boolean actived) {
		this.clientId = clientId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.accountManagerId = accountManagerId;
		this.actived = actived;
	}
	
	/**
	 * @return the clientId
	 */
	public long getClientId() {
		return clientId;
	}
	
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the accountManagerId
	 */
	public long getAccountManagerId() {
		return accountManagerId;
	}
	/**
	 * @param accountManagerId the accountManagerId to set
	 */
	public void setAccountManagerId(long accountManagerId) {
		this.accountManagerId = accountManagerId;
	}
	
	/**
	 * @return the actived
	 */
	public boolean isActived() {
		return actived;
	}
	
	/**
	 * @param actived the actived to set
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", accountManagerId=" + accountManagerId + ", actived=" + actived + "]";
	}
	
}
