package org.pin.entity;

import java.util.List;

public class MetadataArticle {
	
	private String publishedAt;
	private String description;
	private String name;
	List<String> authors;
	
	/**
	 * @return the publishedAt
	 */
	public String getPublishedAt() {
		return publishedAt;
	}
	/**
	 * @param publishedAt the publishedAt to set
	 */
	public void setPublishedAt(String publishedAt) {
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MetadataArticle [publishedAt=" + publishedAt + ", description="
				+ description + ", name=" + name + ", authors=" + authors + "]";
	}
}
