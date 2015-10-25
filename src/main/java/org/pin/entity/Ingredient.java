package org.pin.entity;

import java.util.Map;

/** 
 * Defines an Ingredient class for aggreation with recipe
 * @author Rupak Chakraborty
 * @since 25 October, 2015
 */
public class Ingredient {
	
	private String category;
	private Map<String,String> ingredients;
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the ingredients
	 */
	public Map<String, String> getIngredients() {
		return ingredients;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Map<String, String> ingredients) {
		this.ingredients = ingredients;
	}
}
