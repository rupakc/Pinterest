package org.pin.entity;

import java.util.List;

public class MetadataRecipe {
	
	private String name;
	private String serves;
	private String servingSummary;
	List<Ingredient> ingredients; 
	
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
	 * @return the serves
	 */
	public String getServes() {
		return serves;
	} 
	
	/**
	 * @param serves the serves to set
	 */
	public void setServes(String serves) {
		this.serves = serves;
	} 
	
	/**
	 * @return the servingSummary
	 */
	public String getServingSummary() {
		return servingSummary;
	} 
	
	/**
	 * @param servingSummary the servingSummary to set
	 */
	public void setServingSummary(String servingSummary) {
		this.servingSummary = servingSummary;
	} 
	
	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	} 
	
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
