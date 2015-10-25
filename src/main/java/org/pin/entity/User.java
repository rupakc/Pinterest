package org.pin.entity;

/** 
 * Defines the user object which is retrieved from the user endpoint of the API 
 * @author Rupak Chakraborty
 * @since 25 October,2015
 */
public class User {
	
	private String url;
	private String id;
	private String lastName;
	private String firstName; 
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	} 
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	} 
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	} 
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	} 
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	} 
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	} 
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [url=" + url + ", id=" + id + ", lastName=" + lastName
				+ ", firstName=" + firstName + "]";
	}
}
