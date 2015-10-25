package org.pin.entity;

import java.util.Date;
import java.util.List;

public class MetadataArticle {
	
	private Date publishedAt;
	private String description;
	private String name;
	List<String> authors;
	
	/**
	 * @return the publishedAt
	 */
	public Date getPublishedAt() {
		return publishedAt;
	}
	/**
	 * @param publishedAt the publishedAt to set
	 */
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the authors
	 */
	public List<String> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
}
